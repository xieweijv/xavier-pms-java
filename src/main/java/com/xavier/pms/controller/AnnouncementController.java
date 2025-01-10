package com.xavier.pms.controller;

import com.xavier.pms.req.AnnouncementDto;
import com.xavier.pms.req.AnnouncementQueryDto;
import com.xavier.pms.resp.AnnouncementVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IAnnouncementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请求处理层-公告管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Slf4j
@RequestMapping("announcement")
@RestController
@Tag(name = "公告管理接口")
@RequiredArgsConstructor
public class AnnouncementController extends CommonController {

    private final IAnnouncementService announcementService;

    @Operation(summary = "新增公告", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody AnnouncementDto announcementDto) {
        announcementService.createAnnouncement(announcementDto);
        return Result.ok();
    }

    @Operation(summary = "编辑公告", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody AnnouncementDto announcementDto) {
        announcementService.updateAnnouncement(announcementDto);
        return Result.ok();
    }

    @Operation(summary = "删除公告", description = "@author 星辰")
    @DeleteMapping("delete")
    public Result<Boolean> delete(@RequestBody List<Long> idList) {
        announcementService.deleteAnnouncement(idList);
        return Result.ok();
    }

    @Operation(summary = "获取公告信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    @Parameter(name = "id", description = "id", required = true)
    public Result<AnnouncementVo> get(@PathVariable Long id) {
        return Result.ok(announcementService.getAnnouncement(id));
    }

    @Operation(summary = "分页获取公告列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<QueryResultVo<AnnouncementVo>> queryAnnouncement(@Validated @RequestBody AnnouncementQueryDto announcementQueryDto) {
        return Result.ok(announcementService.queryAnnouncement(announcementQueryDto));
    }

}
