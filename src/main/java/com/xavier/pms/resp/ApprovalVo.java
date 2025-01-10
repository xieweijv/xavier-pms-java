package com.xavier.pms.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "审批出参")
public class ApprovalVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id")
    private Long id;

    @Schema(description = "审批名称")
    private String approvalName;

    @Schema(description = "审批分组id")
    private Long approvalGroupId;

    @Schema(description = "提交类型")
    private String submitType;

    @Schema(description = "图标")
    private String icon;

    @Schema(description = "审批状态")
    private Byte appStatus;

    @Schema(description = "备注")
    private String remarks;

}
