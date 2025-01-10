package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSON;
import com.xavier.pms.model.Post;
import com.xavier.pms.req.PostDto;
import com.xavier.pms.resp.PostVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 职位对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
public abstract class PostConvertor {

    public static PostVo toPostVo(Post post) {
        if (ObjectUtil.isNull(post)) {
            return null;
        }
        PostVo postVo = BeanUtil.beanCopy(post, PostVo.class);
        postVo.setRoleIdList(JSON.parseArray(post.getRole(), Long.class));
        return postVo;
    }

    public static Post toPost(PostDto postDto) {
        if (ObjectUtil.isNull(postDto)) {
            return null;
        }
        Post post = BeanUtil.beanCopy(postDto, Post.class);
        if (CollUtil.isNotEmpty(postDto.getRoleIdList())) {
            post.setRole(JSON.toJSONString(postDto.getRoleIdList()));
        } else {
            post.setRole("");
        }
        return post;
    }

    public static List<PostVo> toPostVoList(List<Post> postList) {
        if (CollUtil.isEmpty(postList)) {
            return new ArrayList<>();
        }
        List<PostVo> postInfoList = new ArrayList<>(postList.size());
        for (Post post : postList) {
            postInfoList.add(toPostVo(post));
        }
        return postInfoList;
    }

}
