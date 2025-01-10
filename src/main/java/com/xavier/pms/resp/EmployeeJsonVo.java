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
@Schema(description = "员工json出参")
public class EmployeeJsonVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "昵称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nickName;


}
