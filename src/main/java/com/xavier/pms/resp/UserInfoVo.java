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
@Schema(description = "登录用户信息")
public class UserInfoVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    @Schema(description = "id")
    private Long id;

    @Schema(description = "登录凭证")
    private String token;

    @Schema(description = "工号")
    private String employeeNumber;

    @Schema(description = "用户昵称")
    private String nickName;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "职位id")
    private Long postId;

    @Schema(description = "过期时间")
    private LocalDateTime expirationTime;

    @Schema(description = "是否管理员")
    private Boolean isAdmin;


}
