package com.xavier.pms.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "菜单入参")
public class MenuDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "父id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "父id不能为空")
    private Long parentId;

    @Schema(description = "菜单编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(max = 100, message = "菜单编码不能超过100位")
    private String menuCode;

    @Schema(description = "菜单类型 M.目录 C.菜单 I.接口", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "菜单类型不能为空")
    @Size(max = 8, message = "菜单类型不能超过8位")
    private String menuType;

    @Schema(description = "菜单名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "菜单名称不能为空")
    @Size(max = 100, message = "菜单名称不能超过100位")
    private String menuName;

    @Schema(description = "组件路径")
    @Size(max = 100, message = "组件路径不能超过100位")
    private String component;

    @Schema(description = "地址")
    @Size(max = 255, message = "地址不能超过255位")
    private String url;

    @Schema(description = "图标")
    @Size(max = 50, message = "图标不能超过50位")
    private String icon;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "排序不能为空")
    private Integer sortNumber;

    @Schema(description = "是否外链", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否外链不能为空")
    private Boolean isFrame;

    @Schema(description = "路由参数")
    @Size(max = 255, message = "路由参数不能超过255位")
    private String query;

    @Schema(description = "是否缓存", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否缓存不能为空")
    private Boolean isCache;

    @Schema(description = "是否启用", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否启用不能为空")
    private Boolean isEnable;

    @Schema(description = "是否显示", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否显示不能为空")
    private Boolean isShow;


}
