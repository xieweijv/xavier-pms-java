package com.xavier.pms.controller;

import com.xavier.pms.req.DepartmentDto;
import com.xavier.pms.req.DepartmentQueryDto;
import com.xavier.pms.resp.DepartmentVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.Result;
import com.xavier.pms.service.IDepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 请求处理层-部门管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Slf4j
@RequestMapping("department")
@RestController
@Tag(name = "部门管理接口")
@RequiredArgsConstructor
public class DepartmentController extends CommonController {

    @Resource
    private IDepartmentService departmentService;

    @Operation(summary = "新增部门", description = "@author 星辰")
    @PutMapping("add")
    public Result add(@Validated @RequestBody DepartmentDto departmentDto) {
        departmentService.createDepartment(departmentDto);
        return Result.ok();
    }

    @Operation(summary = "编辑部门", description = "@author 星辰")
    @PutMapping("update")
    public Result update(@Validated @RequestBody DepartmentDto departmentDto) {
        departmentService.updateDepartment(departmentDto);
        return Result.ok();
    }

    @Operation(summary = "删除部门", description = "@author 星辰")
    @DeleteMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return Result.ok();
    }

    @Operation(summary = "获取部门信息", description = "@author 星辰")
    @GetMapping("get/{id}")
    public Result<DepartmentVo> get(@PathVariable Long id) {
        return Result.ok(departmentService.getDepartment(id));
    }

    @Operation(summary = "分页获取部门列表信息", description = "@author 星辰")
    @PostMapping("query")
    public Result<QueryResultVo<DepartmentVo>> queryDepartment(@Validated @RequestBody DepartmentQueryDto departmentQueryDto) {
        return Result.ok(departmentService.queryDepartment(departmentQueryDto));
    }

}
