package com.xavier.pms.controller;

import cn.hutool.core.util.StrUtil;
import com.xavier.pms.req.EmployeeAddDto;
import com.xavier.pms.req.EmployeeQueryDto;
import com.xavier.pms.req.UpdatePwdDto;
import com.xavier.pms.resp.EmployeeCardVo;
import com.xavier.pms.resp.EmployeeListVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 请求处理层-用户管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Slf4j
@RequestMapping("user")
@RestController
@Tag(name = "用户管理接口")
@RequiredArgsConstructor
public class UserController extends CommonController {

    private final IUserService userService;

    @Operation(summary = "获取公告信息", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody EmployeeAddDto userDto) {
        userService.createUser(userDto);
        return Result.ok();
    }

    @Operation(summary = "获取公告信息", description = "@author 星辰")
    @GetMapping("getEstimatedConversionDate")
    public Result<LocalDate> getEstimatedConversionDate(@RequestParam LocalDate entryDate, @RequestParam int probationPeriod) {
        return Result.ok(entryDate.plusMonths(probationPeriod));
    }

    @Operation(summary = "分页获取员工列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<QueryResultVo<EmployeeListVo>> query(@Validated @RequestBody EmployeeQueryDto dto) {
        return Result.ok(userService.queryEmployee(dto));
    }

    @Operation(summary = "修改密码", description = "@author 星辰")
    @PostMapping("updatePwd")
    public Result updatePwd(@Validated @RequestBody UpdatePwdDto dto) {
        if (StrUtil.equals(dto.getOldPassword(), dto.getNewPassword())) {
            return Result.error("新密码不能和旧密码相同");
        }
        dto.setUserId(getLoginUser().getId());
        userService.updatePwd(dto);
        return Result.ok();
    }

    @Operation(summary = "根据部门id查询员工列表信息", description = "@author 星辰")
    @GetMapping("getByDepartmentId/{departmentId}")
    @Parameter(name = "id", description = "部门id", required = true)
    public Result<List<EmployeeListVo>> getByDepartmentId(@PathVariable Long departmentId) {
        return Result.ok(userService.getByDepartmentId(departmentId));
    }

    @Operation(summary = "根据id查询员工卡片信息", description = "@author 星辰")
    @GetMapping("getCard/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<EmployeeCardVo> getCard(@PathVariable Long id) {
        return Result.ok(userService.getCard(id));
    }


}
