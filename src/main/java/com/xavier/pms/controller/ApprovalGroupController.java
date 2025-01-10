package com.xavier.pms.controller;

import com.xavier.pms.req.ApprovalGroupDto;
import com.xavier.pms.req.ApprovalGroupQueryDto;
import com.xavier.pms.resp.ApprovalGroupVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IApprovalGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请求处理层-审批分组管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Slf4j
@RequestMapping("approvalGroup")
@RestController
@Tag(name = "审批分组管理接口")
@RequiredArgsConstructor
public class ApprovalGroupController extends CommonController {

    private final IApprovalGroupService approvalGroupService;

    @Operation(summary = "获取生效的审批列表", description = "@author 星辰")
    @GetMapping("list")
    public Result<List<ApprovalGroupVo>> list() {
        return Result.ok(approvalGroupService.getList());
    }

    @Operation(summary = "新增审批分组", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody ApprovalGroupDto approvalGroupDto) {
        approvalGroupService.createApprovalGroup(approvalGroupDto);
        return Result.ok();
    }

    @Operation(summary = "编辑审批分组", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody ApprovalGroupDto approvalGroupDto) {
        approvalGroupService.updateApprovalGroup(approvalGroupDto);
        return Result.ok();
    }

    @Operation(summary = "删除审批分组", description = "@author 星辰")
    @DeleteMapping("delete/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<Boolean> delete(@PathVariable Long id) {
        approvalGroupService.deleteApprovalGroup(id);
        return Result.ok();
    }

    @Operation(summary = "获取审批分组信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<ApprovalGroupVo> get(@PathVariable Long id) {
        return Result.ok(approvalGroupService.getApprovalGroup(id));
    }

    @Operation(summary = "分页获取审批分组列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<List<ApprovalGroupVo>> queryApprovalGroup(@Validated @RequestBody ApprovalGroupQueryDto approvalGroupQueryDto) {
        return Result.ok(approvalGroupService.queryApprovalGroup(approvalGroupQueryDto));
    }

}
