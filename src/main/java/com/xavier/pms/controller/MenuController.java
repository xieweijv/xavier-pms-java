package com.xavier.pms.controller;

import com.xavier.pms.req.MenuDto;
import com.xavier.pms.resp.MenuVo;
import com.xavier.pms.resp.RouterVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请求处理层-菜单管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Slf4j
@RequestMapping("menu")
@RestController
@Tag(name = "菜单管理接口")
@RequiredArgsConstructor
public class MenuController extends CommonController {

    private final IMenuService menuService;

    @Operation(summary = "获取当前登录用户的菜单", description = "@author 星辰")
    @GetMapping("getUserMenu")
    public Result<List<RouterVo>> getUserMenu() {
        return Result.ok(menuService.getUserMenu(getLoginUser()));
    }

    @Operation(summary = "获取所有菜单树", description = "@author 星辰")
    @GetMapping("getTree")
    public Result<List<MenuVo>> getTree() {
        return Result.ok(menuService.getTree(getLoginUser()));
    }

    @Operation(summary = "新增菜单", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody MenuDto menuDto) {
        menuService.createMenu(menuDto);
        return Result.ok();
    }

    @Operation(summary = "编辑菜单", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody MenuDto menuDto) {
        menuService.updateMenu(menuDto);
        return Result.ok();
    }

    @Operation(summary = "删除菜单", description = "@author 星辰")
    @DeleteMapping("delete/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<Integer> delete(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return Result.ok();
    }

    @Operation(summary = "获取菜单信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<MenuVo> get(@PathVariable Long id) {
        return Result.ok(menuService.getMenu(id));
    }


}
