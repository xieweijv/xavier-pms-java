package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSON;
import com.xavier.pms.model.UserGroup;
import com.xavier.pms.req.UserGroupDto;
import com.xavier.pms.resp.EmployeeJsonVo;
import com.xavier.pms.resp.UserGroupVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工组对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
public abstract class UserGroupConvertor {

    public static UserGroupVo toUserGroupVo(UserGroup userGroup) {
        if (ObjectUtil.isNull(userGroup)) {
            return null;
        }
        UserGroupVo userGroupVo = BeanUtil.beanCopy(userGroup, UserGroupVo.class);
        userGroupVo.setEmployeeList(JSON.parseArray(userGroup.getMemberJson(), EmployeeJsonVo.class));
        return userGroupVo;
    }

    public static UserGroup toUserGroup(UserGroupDto userGroupDto) {
        if (ObjectUtil.isNull(userGroupDto)) {
            return null;
        }
        UserGroup userGroup = BeanUtil.beanCopy(userGroupDto, UserGroup.class);
        userGroup.setMemberJson(JSON.toJSONString(userGroupDto.getEmployeeList()));
        return userGroup;
    }

    public static List<UserGroupVo> toUserGroupVoList(List<UserGroup> userGroupList) {
        if (CollUtil.isEmpty(userGroupList)) {
            return new ArrayList<>();
        }
        List<UserGroupVo> userGroupInfoList = new ArrayList<>(userGroupList.size());
        for (UserGroup userGroup : userGroupList) {
            userGroupInfoList.add(toUserGroupVo(userGroup));
        }
        return userGroupInfoList;
    }

}
