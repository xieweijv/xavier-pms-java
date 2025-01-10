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
@Schema(description = "审批单流程详细出参")
public class AuditFormFlowDetailVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id")
    private Long userId;

    @Schema(description = "姓名")
    private String nickName;

    @Schema(description = "审批类型")
    private String approvalType;

    @Schema(description = "审批状态")
    private Byte auditStatus;

}
