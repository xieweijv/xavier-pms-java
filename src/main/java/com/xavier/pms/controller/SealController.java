package com.xavier.pms.controller;

import com.xavier.pms.req.SealDto;
import com.xavier.pms.req.SealQueryDto;
import com.xavier.pms.resp.SealVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.ISealService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请求处理层-印章管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Slf4j
@RequestMapping("seal")
@RestController
@Tag(name = "印章管理接口")
@RequiredArgsConstructor
public class SealController extends CommonController {

    private final ISealService sealService;

    @Operation(summary = "新增印章", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody SealDto sealDto) {
        sealService.createSeal(sealDto);
        return Result.ok();
    }

    @Operation(summary = "编辑印章", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody SealDto sealDto) {
        sealService.updateSeal(sealDto);
        return Result.ok();
    }

    @Operation(summary = "删除印章", description = "@author 星辰")
    @DeleteMapping("delete")
    public Result<Boolean> delete(@RequestBody List<Long> idList) {
        sealService.deleteSeal(idList);
        return Result.ok();
    }

    @Operation(summary = "获取印章信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    public Result<SealVo> get(@PathVariable Long id) {
        return Result.ok(sealService.getSeal(id));
    }

    @Operation(summary = "分页获取印章列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<QueryResultVo<SealVo>> querySeal(@Validated @RequestBody SealQueryDto sealQueryDto) {
        return Result.ok(sealService.querySeal(sealQueryDto));
    }

}
