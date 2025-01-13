package com.xavier.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xavier.pms.model.Announcement;
import com.xavier.pms.req.AnnouncementQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 数据持久层-公告管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    Page<Announcement> queryAnnouncement(@Param("dto") AnnouncementQueryDto queryDTO, Page<Announcement> page);

}
