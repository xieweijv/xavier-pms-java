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
@Schema(description = "审批单审批入参")
public class AuditFormAuditDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "id不能为空")
    private Long id;

    /**
     * 是否通过
     */
    @Schema(description = "是否通过", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否通过不能为空")
    private Boolean pass;

    /**
     * 备注
     */
    @Schema(description = "备注", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "备注不能为空")
    @NotEmpty(message = "备注不能为空")
    @Size(max = 255, message = "备注不能超过255位")
    private String remarks;


}
