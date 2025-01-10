package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.model.Role;
import com.xavier.pms.req.RoleDto;
import com.xavier.pms.resp.RoleVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
public abstract class RoleConvertor {

    public static RoleVo toRoleVo(Role role) {
        if (ObjectUtil.isNull(role)) {
            return null;
        }
        return BeanUtil.beanCopy(role, RoleVo.class);
    }

    public static Role toRole(RoleDto roleDto) {
        if (ObjectUtil.isNull(roleDto)) {
            return null;
        }
        return BeanUtil.beanCopy(roleDto, Role.class);
    }

    public static List<RoleVo> toRoleVoList(List<Role> roleList) {
        if (CollUtil.isEmpty(roleList)) {
            return new ArrayList<>();
        }
        List<RoleVo> roleInfoList = new ArrayList<>(roleList.size());
        for (Role role : roleList) {
            roleInfoList.add(toRoleVo(role));
        }
        return roleInfoList;
    }

}
