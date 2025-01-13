package com.xavier.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xavier.pms.req.ApprovalDto;
import com.xavier.pms.req.ApprovalStatusDto;
import com.xavier.pms.model.Approval;
import com.xavier.pms.resp.ApprovalDetailVo;

/**
 * 业务逻辑层-审批接口类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public interface IApprovalService extends IService<Approval> {

    /**
     * 创建审批
     *
     * @param dto 审批入参
     * @return id
     */
    Long createApproval(ApprovalDto dto);

    /**
     * 更新审批
     *
     * @param dto 审批入参
     */
    void updateApproval(ApprovalDto dto);

    /**
     * 删除审批
     *
     * @param id
     */
    void deleteApproval(Long id);

    /**
     * 根据ID获取审批信息
     *
     * @param id
     * @return 审批信息
     */
    ApprovalDetailVo getApproval(Long id);

    /**
     * 根据ID获取审批信息
     *
     * @param id
     * @return 审批信息
     */
    Approval getBaseApproval(Long id);


    /**
     * 修改状态
     */
    void updateStatus(ApprovalStatusDto dto);
}
