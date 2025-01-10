package com.xavier.pms.controller;

import com.xavier.pms.req.RoleDto;
import com.xavier.pms.req.RoleQueryDto;
import com.xavier.pms.resp.RoleVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请求处理层-角色管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Slf4j
@RequestMapping("role")
@RestController
@Tag(name = "角色管理接口")
@RequiredArgsConstructor
public class RoleController extends CommonController {

    private final IRoleService roleService;

    @Operation(summary = "新增角色", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody RoleDto roleDto) {
        roleService.createRole(roleDto);
        return Result.ok();
    }

    @Operation(summary = "编辑角色", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody RoleDto roleDto) {
        roleService.updateRole(roleDto);
        return Result.ok();
    }

    @Operation(summary = "删除角色", description = "@author 星辰")
    @DeleteMapping("delete")
    public Result<Integer> delete(@RequestBody List<Long> idList) {
        roleService.deleteRole(idList);
        return Result.ok();
    }

    @Operation(summary = "获取角色信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<RoleVo> get(@PathVariable Long id) {
        return Result.ok(roleService.getRole(id));
    }

    @Operation(summary = "分页获取角色列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<QueryResultVo<RoleVo>> queryRole(@Validated @RequestBody RoleQueryDto roleQueryDto) {
        return Result.ok(roleService.queryRole(roleQueryDto));
    }

}
