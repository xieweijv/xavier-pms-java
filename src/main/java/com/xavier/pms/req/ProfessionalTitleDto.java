package com.xavier.pms.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "职称入参")
public class ProfessionalTitleDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "职称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "职称不能为空")
    @Size(max = 255, message = "职称不能超过255位")
    private String titleName;

    @Schema(description = "备注")
    @Size(max = 255, message = "备注不能超过255位")
    private String remarks;


}
