package com.xavier.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xavier.pms.req.ApprovalGroupQueryDto;
import com.xavier.pms.model.ApprovalGroup;
import com.xavier.pms.resp.ApprovalGroupVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据持久层-审批分组管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Mapper
public interface ApprovalGroupMapper extends BaseMapper<ApprovalGroup> {

    List<ApprovalGroupVo> queryApprovalGroup(@Param("dto") ApprovalGroupQueryDto queryDTO);

}
