package com.xavier.pms.controller;

import com.xavier.pms.req.AuditFormAuditDto;
import com.xavier.pms.req.AuditFormDto;
import com.xavier.pms.req.AuditFormQueryDto;
import com.xavier.pms.req.AuditFormRevocationDto;
import com.xavier.pms.resp.AuditFormFlowVo;
import com.xavier.pms.resp.AuditFormVo;
import com.xavier.pms.resp.UserInfoVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IAuditFormFlowService;
import com.xavier.pms.service.IAuditFormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请求处理层-审批单管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Slf4j
@RequestMapping("auditForm")
@RestController
@Tag(name = "审批单管理接口")
@RequiredArgsConstructor
public class AuditFormController extends CommonController {

    private final IAuditFormService auditFormService;
    private final IAuditFormFlowService auditFormFlowService;

    @Operation(summary = "新增审批单", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody AuditFormDto auditFormDto) {
        UserInfoVo loginUser = getLoginUser();
        auditFormService.createAuditForm(loginUser, auditFormDto);
        return Result.ok();
    }

    @Operation(summary = "获取审批单信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<AuditFormVo> get(@PathVariable Long id) {
        return Result.ok(auditFormService.getAuditForm(id, getLoginUser().getId()));
    }

    @Operation(summary = "根据审批单id获取审批单流程信息", description = "@author 星辰")
    @GetMapping("getProcess/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<List<AuditFormFlowVo>> getProcess(@PathVariable Long id) {
        return Result.ok(auditFormFlowService.getProcessByAuditFormId(id));
    }

    @Operation(summary = "分页获取审批单列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<QueryResultVo<AuditFormVo>> queryAuditForm(@Validated @RequestBody AuditFormQueryDto auditFormQueryDto) {
        auditFormQueryDto.setUserId(getLoginUser().getId());
        return Result.ok(auditFormService.queryAuditForm(auditFormQueryDto));
    }

    @Operation(summary = "撤回审批单", description = "@author 星辰")
    @PostMapping("revocation")
    public Result revocation(@Validated @RequestBody AuditFormRevocationDto dto) {
        auditFormService.revocation(dto, getLoginUser());
        return Result.ok();
    }

    @Operation(summary = "审批审批单", description = "@author 星辰")
    @PostMapping("audit")
    public Result audit(@Validated @RequestBody AuditFormAuditDto dto) {
        auditFormService.audit(dto, getLoginUser());
        return Result.ok();
    }

}
