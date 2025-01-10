package com.xavier.pms.controller;

import cn.hutool.core.collection.CollUtil;
import com.wf.captcha.ArithmeticCaptcha;
import com.xavier.pms.constants.Constant;
import com.xavier.pms.req.LoginDto;
import com.xavier.pms.resp.UserInfoVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IUserService;
import com.xavier.pms.service.IUserTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * 请求处理层-登录管理类
 *
 * @author Xavier
 * @version 1.0
 */
@Slf4j
@RequestMapping("")
@RestController
@Tag(name = "登录管理接口")
@RequiredArgsConstructor
public class LoginController extends CommonController {

    private final IUserService userService;
    private final IUserTokenService userTokenService;

    @Operation(summary = "获取图形验证码", description = "@author 星辰")
    @PostMapping("getCaptchaImage")
    public Result<Map<String, String>> getCaptchaImage() {
        Map<String, String> data = new HashMap<>();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(120, 40);
        // 获取运算的公式
        captcha.getArithmeticString();
        // 获取运算的结果
        String text = captcha.text();
        data.put("uuid", uuid);
        data.put("codeUrl", captcha.toBase64());

        getSession().setAttribute(Constant.CAPTCHA_KEY + uuid, text);

        return Result.ok(data);
    }

    @Operation(summary = "用户登录", description = "@author 星辰")
    @PostMapping("login")
    public Result<String> login(@Validated @RequestBody LoginDto dto) {
        // 验证验证码
        Object object = getSession().getAttribute(Constant.CAPTCHA_KEY + dto.getUuid());
        if (Objects.isNull(object)) {
            return Result.error("验证码失效");
        }
        if (!Objects.equals(object.toString(), dto.getVerCode())) {
            return Result.error("验证码错误");
        }
        return Result.ok(userService.login(dto));
    }

    @Operation(summary = "用户退出", description = "@author 星辰")
    @PostMapping("logout")
    public Result logout() {
        UserInfoVo loginUser = getLoginUser();
        if (Objects.nonNull(loginUser)) {
            userTokenService.deleteByToken(loginUser.getToken());
        }
        return Result.ok();
    }

    @Operation(summary = "获取登录用户信息", description = "@author 星辰")
    @GetMapping("getInfo")
    public Result<Map<String, Object>> getInfo() {
        Map<String, Object> map = new HashMap<>();
        UserInfoVo user = super.getLoginUser();
        map.put("user", user);
        if (user.getIsAdmin()) {
            map.put("permissions", CollUtil.newArrayList("*:*:*"));
        }
        // todo 非管理员权限
        return Result.ok(map);
    }


}
