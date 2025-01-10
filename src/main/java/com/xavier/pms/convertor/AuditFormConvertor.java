package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.xavier.pms.enums.AuditStatusEnum;
import com.xavier.pms.model.AuditForm;
import com.xavier.pms.model.AuditFormFlow;
import com.xavier.pms.model.AuditFormFlowDetail;
import com.xavier.pms.req.AuditFormDto;
import com.xavier.pms.resp.AuditFormFlowDetailVo;
import com.xavier.pms.resp.AuditFormFlowVo;
import com.xavier.pms.resp.AuditFormVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 审批单对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
public abstract class AuditFormConvertor {

    public static AuditFormVo toAuditFormVo(AuditForm auditForm) {
        if (ObjectUtil.isNull(auditForm)) {
            return null;
        }
        AuditFormVo auditFormVo = BeanUtil.beanCopy(auditForm, AuditFormVo.class);
        auditFormVo.setAuditStatusDesc(AuditStatusEnum.getDescByValue(auditForm.getAuditStatus()));
        return auditFormVo;
    }

    public static AuditForm toAuditForm(AuditFormDto auditFormDto) {
        if (ObjectUtil.isNull(auditFormDto)) {
            return null;
        }
        return BeanUtil.beanCopy(auditFormDto, AuditForm.class);
    }

    public static AuditFormFlowVo toAuditFormFlowVo(AuditFormFlow auditFormFlow, List<AuditFormFlowDetail> detailList) {
        AuditFormFlowVo vo = BeanUtil.beanCopy(auditFormFlow, AuditFormFlowVo.class);
        vo.setDetailList(BeanUtil.beanCopy(detailList, AuditFormFlowDetailVo.class));
        vo.setAuditStatus(detailList.get(0).getAuditStatus());
        List<AuditFormFlowDetail> remarks = detailList.stream().filter(bean -> StrUtil.isNotBlank(bean.getRemarks())).collect(Collectors.toList());
        List<AuditFormFlowDetail> dealTimes = detailList.stream().filter(bean -> Objects.nonNull(bean.getDealTime())).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(remarks)) {
            vo.setRemarks(remarks.get(0).getRemarks());
        }
        if (CollUtil.isNotEmpty(dealTimes)) {
            vo.setDealTime(dealTimes.get(0).getDealTime());
        }
        return vo;
    }

    public static List<AuditFormVo> toAuditFormVoList(List<AuditForm> auditFormList) {
        if (CollUtil.isEmpty(auditFormList)) {
            return new ArrayList<>();
        }
        List<AuditFormVo> auditFormInfoList = new ArrayList<>(auditFormList.size());
        for (AuditForm auditForm : auditFormList) {
            auditFormInfoList.add(toAuditFormVo(auditForm));
        }
        return auditFormInfoList;
    }


}
