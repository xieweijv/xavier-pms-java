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
@Schema(description = "审批分组出参")
public class ApprovalGroupVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id")
    private Long id;

    @Schema(description = "分组名称")
    private String groupName;

    @Schema(description = "排序")
    private Integer sortNumber;

    @Schema(description = "备注")
    private String remarks;

    @Schema(description = "审批列表")
    private List<ApprovalVo> approvalList;

}
