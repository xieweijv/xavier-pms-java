package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.constants.Constant;
import com.xavier.pms.model.Menu;
import com.xavier.pms.req.MenuDto;
import com.xavier.pms.resp.MenuVo;
import com.xavier.pms.resp.MetaVo;
import com.xavier.pms.resp.RouterVo;
import com.xavier.pms.utils.BeanUtil;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 菜单对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public abstract class MenuConvertor {

    public static MenuVo toMenuVo(Menu menu) {
        if (ObjectUtil.isNull(menu)) {
            return null;
        }
        return BeanUtil.beanCopy(menu, MenuVo.class);
    }

    public static Menu toMenu(MenuDto menuDto) {
        if (ObjectUtil.isNull(menuDto)) {
            return null;
        }
        Menu menu = BeanUtil.beanCopy(menuDto, Menu.class);
        if (Objects.equals(Constant.MENU_DIRECTORY, menuDto.getMenuType())) {
            menu.setComponent("Layout");
        }
        return menu;
    }

    public static List<MenuVo> toMenuVoList(List<Menu> menuList) {
        if (CollUtil.isEmpty(menuList)) {
            return new ArrayList<>();
        }
        List<MenuVo> menuInfoList = new ArrayList<>(menuList.size());
        for (Menu menu : menuList) {
            menuInfoList.add(toMenuVo(menu));
        }
        return menuInfoList;
    }

    public static List<MenuVo> toTree(List<Menu> menuList) {
        // 顶级类目
        List<MenuVo> topList = Collections.EMPTY_LIST;
        if (!CollectionUtils.isEmpty(menuList)) {
            topList = toMenuVoList(menuList.stream().filter(bean -> bean.getParentId().equals(0L)).sorted(Comparator.comparing(Menu::getSortNumber)).collect(Collectors.toList()));
            List<MenuVo> childList = toMenuVoList(menuList.stream().filter(bean -> !bean.getParentId().equals(0L)).collect(Collectors.toList()));
            sort(topList, childList);

            return topList;
        }
        return topList;
    }

    private static void sort(List<MenuVo> topList, List<MenuVo> childList) {
        if (!CollectionUtils.isEmpty(childList) && !CollectionUtils.isEmpty(topList)) {
            List<MenuVo> copyVos = CollUtil.newCopyOnWriteArrayList(childList);
            for (MenuVo top : topList) {
                for (MenuVo child : childList) {
                    if (Objects.equals(top.getId(), child.getParentId())) {
                        top.addChildren(child);
                        copyVos.remove(child);
                    }
                }
            }
            for (MenuVo top : topList) {
                if (!CollectionUtils.isEmpty(top.getChildren())) {
                    // 子菜单排序
                    top.setChildren(top.getChildren().stream().sorted(Comparator.comparing(MenuVo::getSortNumber)).collect(Collectors.toList()));
                    sort(top.getChildren(), copyVos);
                }
            }
        }
    }

    public static List<RouterVo> toRouterVoList(List<Menu> menuList) {
        if (!CollectionUtils.isEmpty(menuList)) {
            List<Menu> topList = menuList.stream().filter(bean -> bean.getParentId().equals(0L)).sorted(Comparator.comparing(Menu::getSortNumber)).collect(Collectors.toList());
            List<Menu> childList = menuList.stream().filter(bean -> !bean.getParentId().equals(0L)).collect(Collectors.toList());
            return sortRouter(topList, childList);
        }
        return Collections.EMPTY_LIST;
    }

    private static List<RouterVo> sortRouter(List<Menu> topList, List<Menu> childList) {
        List<RouterVo> routerVoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(topList) && !CollectionUtils.isEmpty(childList)) {
            List<Menu> copyVos = CollUtil.newCopyOnWriteArrayList(childList);
            for (Menu top : topList) {
                for (Menu child : childList) {
                    if (Objects.equals(top.getId(), child.getParentId())) {
                        top.addChildren(child);
                        copyVos.remove(child);
                    }
                }
            }
            for (Menu top : topList) {
                RouterVo routerVo = toRouterVo(top);
                if (!CollectionUtils.isEmpty(top.getChildren())) {
                    // 子菜单排序
                    List<Menu> childrenMenus = top.getChildren().stream().sorted(Comparator.comparing(Menu::getSortNumber)).collect(Collectors.toList());
                    List<RouterVo> children = new ArrayList<>();
                    for (Menu child : childrenMenus) {
                        children.add(toRouterVo(child));
                    }
                    routerVo.setChildren(children);
                    sortRouter(top.getChildren(), copyVos);
                }
                routerVoList.add(routerVo);
            }
        }
        return routerVoList;
    }

    private static RouterVo toRouterVo(Menu menu) {
        RouterVo routerVo = BeanUtil.beanCopy(menu, RouterVo.class);
        routerVo.setName(menu.getMenuName());
        routerVo.setPath(menu.getUrl());
        routerVo.setHidden(!menu.getIsShow());
        routerVo.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), !menu.getIsCache(), ""));
        if (CollUtil.isNotEmpty(menu.getChildren()) && Objects.equals(Constant.MENU_DIRECTORY, menu.getMenuType())) {
            routerVo.setAlwaysShow(true);
        }
        return routerVo;
    }

}
