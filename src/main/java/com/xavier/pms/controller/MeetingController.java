package com.xavier.pms.controller;

import com.xavier.pms.req.MeetingDto;
import com.xavier.pms.req.MeetingQueryDto;
import com.xavier.pms.resp.MeetingVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IMeetingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请求处理层-会议室管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Slf4j
@RequestMapping("meeting")
@RestController
@Tag(name = "会议室管理接口")
@RequiredArgsConstructor
public class MeetingController extends CommonController {

    private final IMeetingService meetingService;

    @Operation(summary = "新增会议室", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody MeetingDto meetingDto) {
        meetingService.createMeeting(meetingDto);
        return Result.ok();
    }

    @Operation(summary = "编辑会议室", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody MeetingDto meetingDto) {
        meetingService.updateMeeting(meetingDto);
        return Result.ok();
    }

    @Operation(summary = "删除会议室", description = "@author 星辰")
    @DeleteMapping("delete")
    public Result<Boolean> delete(@RequestBody List<Long> idList) {
        meetingService.deleteMeeting(idList);
        return Result.ok();
    }

    @Operation(summary = "获取会议室信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<MeetingVo> get(@PathVariable Long id) {
        return Result.ok(meetingService.getMeeting(id));
    }

    @Operation(summary = "分页获取会议室列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<QueryResultVo<MeetingVo>> queryMeeting(@Validated @RequestBody MeetingQueryDto meetingQueryDto) {
        return Result.ok(meetingService.queryMeeting(meetingQueryDto));
    }

}
