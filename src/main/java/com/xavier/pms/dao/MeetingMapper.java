package com.xavier.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xavier.pms.model.Meeting;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据持久层-会议室管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Mapper
public interface MeetingMapper extends BaseMapper<Meeting> {
    


}
