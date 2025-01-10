package com.xavier.pms.controller;

import com.xavier.pms.req.UserGroupDto;
import com.xavier.pms.req.UserGroupQueryDto;
import com.xavier.pms.resp.UserGroupVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IUserGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请求处理层-员工组管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Slf4j
@RequestMapping("userGroup")
@RestController
@Tag(name = "公告管理接口")
@RequiredArgsConstructor
public class UserGroupController extends CommonController {

    private final IUserGroupService userGroupService;

    @Operation(summary = "新增员工组", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody UserGroupDto userGroupDto) {
        userGroupDto.setUserId(getLoginUser().getId());
        userGroupService.createUserGroup(userGroupDto);
        return Result.ok();
    }

    @Operation(summary = "编辑员工组", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody UserGroupDto userGroupDto) {
        userGroupService.updateUserGroup(userGroupDto);
        return Result.ok();
    }

    @Operation(summary = "删除员工组", description = "@author 星辰")
    @DeleteMapping("delete")
    public Result delete(@RequestBody List<Long> idList) {
        userGroupService.deleteUserGroup(idList);
        return Result.ok();
    }

    @Operation(summary = "获取员工组信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<UserGroupVo> get(@PathVariable Long id) {
        return Result.ok(userGroupService.getUserGroup(id));
    }

    @Operation(summary = "分页获取员工组列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<QueryResultVo<UserGroupVo>> queryUserGroup(@Validated @RequestBody UserGroupQueryDto userGroupQueryDto) {
        userGroupQueryDto.setUserId(getLoginUser().getId());
        return Result.ok(userGroupService.queryUserGroup(userGroupQueryDto));
    }

}
