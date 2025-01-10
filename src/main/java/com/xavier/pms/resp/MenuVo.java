package com.xavier.pms.resp;

import cn.hutool.core.collection.CollUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "菜单出参")
public class MenuVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id")
    private Long id;

    @Schema(description = "父id")
    private Long parentId;

    @Schema(description = "菜单编码")
    private String menuCode;

    @Schema(description = "菜单类型 M.目录 C.菜单 I.接口")
    private String menuType;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "组件路径")
    private String component;

    @Schema(description = "地址")
    private String url;

    @Schema(description = "图标")
    private String icon;

    @Schema(description = "排序")
    private Integer sortNumber;

    @Schema(description = "是否外链")
    private Boolean isFrame;

    @Schema(description = "路由参数")
    private String query;

    @Schema(description = "是否缓存")
    private Boolean isCache;

    @Schema(description = "是否显示")
    private Boolean isShow;

    @Schema(description = "是否启用")
    private Boolean isEnable;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    @Schema(description = "子菜单集合")
    private List<MenuVo> children;

    /**
     * 增加子菜单
     */
    public void addChildren(MenuVo menuVo) {
        if (CollUtil.isEmpty(children)) {
            children = new ArrayList<>();
        }
        children.add(menuVo);
    }

}
