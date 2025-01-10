package com.xavier.pms.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "审批单出参")
public class AuditFormVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "姓名")
    private String nickName;

    @Schema(description = "审批id")
    private Long approvalId;

    @Schema(description = "审批名称")
    private String approvalName;

    @Schema(description = "表单json")
    private String form;

    @Schema(description = "表单数据")
    private String formData;

    @Schema(description = "审批流程")
    private String approvalProcess;

    @Schema(description = "审批状态")
    private Byte auditStatus;

    @Schema(description = "审批状态描述")
    private String auditStatusDesc;

    @Schema(description = "备注")
    private String remarks;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "展示操作按钮")
    private Button button;

    @Data
    @ToString(callSuper = true)
    @Schema(description = "审批单按钮出参")
    public static class Button {

        @Schema(description = "是否展示审批按钮")
        private Boolean audit;

        @Schema(description = "是否展示办理按钮")
        private Boolean handler;

        @Schema(description = "是否展示撤回按钮")
        private Boolean revocation;

        public Button() {
            this.audit = false;
            this.handler = false;
            this.revocation = false;
        }
    }

}
