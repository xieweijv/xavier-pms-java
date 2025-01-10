package com.xavier.pms.convertor;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSON;
import com.xavier.pms.model.Approval;
import com.xavier.pms.req.ApprovalDto;
import com.xavier.pms.resp.ApprovalDetailVo;
import com.xavier.pms.resp.ApprovalProcessJsonVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.Objects;

/**
 * 审批对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
public abstract class ApprovalConvertor {

    public static ApprovalDetailVo toApprovalDetailVo(Approval approval) {
        if (ObjectUtil.isNull(approval)) {
            return null;
        }
        return BeanUtil.beanCopy(approval, ApprovalDetailVo.class);
    }

    public static Approval toApproval(ApprovalDto dto) {
        Approval approval = BeanUtil.beanCopy(dto, Approval.class);
        approval.setProcess(JSON.toJSONString(dto.getProcessList()));
        for (ApprovalProcessJsonVo jsonVo : dto.getProcessList()) {
            if (Objects.equals(jsonVo.getApprovalType(), "start")) {
                // 提交
                approval.setSubmitType(jsonVo.getSubmitType());
            }
        }
        return approval;
    }


}
