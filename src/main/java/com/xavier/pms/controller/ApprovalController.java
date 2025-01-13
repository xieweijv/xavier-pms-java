package com.xavier.pms.controller;

import com.xavier.pms.req.ApprovalDto;
import com.xavier.pms.req.ApprovalStatusDto;
import com.xavier.pms.resp.ApprovalDetailVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IApprovalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 请求处理层-审批管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Slf4j
@RequestMapping("approval")
@RestController
@Tag(name = "审批管理接口")
@RequiredArgsConstructor
public class ApprovalController extends CommonController {

    private final IApprovalService approvalService;

    @Operation(summary = "新增审批", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody ApprovalDto dto) {
        approvalService.createApproval(dto);
        return Result.ok();
    }

    @Operation(summary = "编辑审批", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody ApprovalDto dto) {
        approvalService.updateApproval(dto);
        return Result.ok();
    }

    @Operation(summary = "删除审批", description = "@author 星辰")
    @DeleteMapping("delete/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<Boolean> delete(@PathVariable Long id) {
        approvalService.deleteApproval(id);
        return Result.ok();
    }

    @Operation(summary = "修改状态", description = "@author 星辰")
    @PostMapping("updateStatus")
    public Result<Boolean> updateStatus(@Validated @RequestBody ApprovalStatusDto dto) {
        approvalService.updateStatus(dto);
        return Result.ok();
    }

    @Operation(summary = "获取审批信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<ApprovalDetailVo> get(@PathVariable Long id) {
        return Result.ok(approvalService.getApproval(id));
    }

}
