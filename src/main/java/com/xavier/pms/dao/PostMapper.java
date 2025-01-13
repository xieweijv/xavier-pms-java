package com.xavier.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xavier.pms.model.Post;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据持久层-职位管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {


}
