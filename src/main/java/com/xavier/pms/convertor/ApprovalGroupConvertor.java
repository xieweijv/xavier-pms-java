package com.xavier.pms.convertor;

import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.model.ApprovalGroup;
import com.xavier.pms.req.ApprovalGroupDto;
import com.xavier.pms.resp.ApprovalGroupVo;
import com.xavier.pms.utils.BeanUtil;

/**
 * 审批分组对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
public abstract class ApprovalGroupConvertor {

    public static ApprovalGroupVo toApprovalGroupVo(ApprovalGroup approvalGroup) {
        if (ObjectUtil.isNull(approvalGroup)) {
            return null;
        }
        return BeanUtil.beanCopy(approvalGroup, ApprovalGroupVo.class);
    }

    public static ApprovalGroup toApprovalGroup(ApprovalGroupDto approvalGroupDto) {
        if (ObjectUtil.isNull(approvalGroupDto)) {
            return null;
        }
        return BeanUtil.beanCopy(approvalGroupDto, ApprovalGroup.class);
    }

}
