package com.xavier.pms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xavier.pms.convertor.AnnouncementTypeConvertor;
import com.xavier.pms.dao.AnnouncementTypeMapper;
import com.xavier.pms.model.Announcement;
import com.xavier.pms.model.AnnouncementType;
import com.xavier.pms.req.AnnouncementTypeDto;
import com.xavier.pms.req.AnnouncementTypeQueryDto;
import com.xavier.pms.resp.AnnouncementTypeVo;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.ResultCode;
import com.xavier.pms.service.IAnnouncementService;
import com.xavier.pms.service.IAnnouncementTypeService;
import com.xavier.pms.utils.BeanUtil;
import com.xavier.pms.utils.ServiceException;
import com.xavier.pms.utils.XavierLambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * 业务逻辑层-公告类型实现类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AnnouncementTypeServiceImpl extends ServiceImpl<AnnouncementTypeMapper, AnnouncementType> implements IAnnouncementTypeService {

    private final IAnnouncementService announcementService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createAnnouncementType(AnnouncementTypeDto announcementTypeDto) {
        AnnouncementType announcementType = AnnouncementTypeConvertor.toAnnouncementType(announcementTypeDto);
        announcementType.setId(null);
        super.save(announcementType);
        return announcementType.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateAnnouncementType(AnnouncementTypeDto announcementTypeDto) {
        getBaseAnnouncementType(announcementTypeDto.getId());
        AnnouncementType announcementType = AnnouncementTypeConvertor.toAnnouncementType(announcementTypeDto);
        return super.updateById(announcementType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteAnnouncementType(List<Long> idList) {
        if (announcementService.count(Announcement.gw().in(Announcement::getAnnouncementTypeId, idList)) > 0) {
            throw new ServiceException("类型下有公告无法删除");
        }
        return super.removeBatchByIds(idList);
    }

    @Override
    public AnnouncementTypeVo getAnnouncementType(Long id) {
        return AnnouncementTypeConvertor.toAnnouncementTypeVo(getBaseAnnouncementType(id));
    }


    @Override
    public AnnouncementType getBaseAnnouncementType(Long id) {
        AnnouncementType announcementType = super.getById(id);
        if (Objects.isNull(announcementType)) {
            throw new ServiceException(ResultCode.DATA_NOT_EXIST, "公告类型");
        }
        return announcementType;
    }

    @Override
    public QueryResultVo<AnnouncementTypeVo> queryAnnouncementType(AnnouncementTypeQueryDto queryDTO) {
        Page<AnnouncementType> page = new Page<>();
        page.setCurrent(queryDTO.getPageNo());
        page.setSize(queryDTO.getPageSize());
        XavierLambdaQueryWrapper<AnnouncementType> wrapper = AnnouncementType.gw();
        // id不为空
        wrapper.eqIfPresent(AnnouncementType::getId, queryDTO.getId());
        // 类型名称不为空
        wrapper.likeIfPresent(AnnouncementType::getTypeName, queryDTO.getTypeName());
        wrapper.eqIfPresent(AnnouncementType::getSortNumber, queryDTO.getSortNumber());
        // 备注不为空
        wrapper.likeIfPresent(AnnouncementType::getRemarks, queryDTO.getRemarks());
        // 创建时间大于等于
        wrapper.geIfPresent(AnnouncementType::getCreateTime, queryDTO.getCreateTimeFrom());
        wrapper.leIfPresent(AnnouncementType::getCreateTime, queryDTO.getCreateTimeTo());
        wrapper.orderByAsc(AnnouncementType::getSortNumber);
        wrapper.orderByDesc(AnnouncementType::getId);
        Page<AnnouncementType> result = super.page(page, wrapper);
        QueryResultVo<AnnouncementTypeVo> queryResultVo = BeanUtil.pageToQueryResultVo(result, AnnouncementTypeVo.class);
        queryResultVo.setRecords(AnnouncementTypeConvertor.toAnnouncementTypeVoList(result.getRecords()));
        return queryResultVo;
    }

}
