package com.xavier.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xavier.pms.req.AuditFormQueryDto;
import com.xavier.pms.model.AuditForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 数据持久层-审批单管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Mapper
public interface AuditFormMapper extends BaseMapper<AuditForm> {

    Page<AuditForm> queryAuditForm(@Param("dto") AuditFormQueryDto queryDTO, Page<AuditForm> page);

}
