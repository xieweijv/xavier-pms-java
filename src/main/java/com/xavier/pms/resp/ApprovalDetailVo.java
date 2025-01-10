package com.xavier.pms.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "审批详情出参")
public class ApprovalDetailVo implements Serializable {

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

    @Schema(description = "表单设计")
    private String form;

    @Schema(description = "流程列表")
    private List<ApprovalProcessJsonVo> processList;

}
