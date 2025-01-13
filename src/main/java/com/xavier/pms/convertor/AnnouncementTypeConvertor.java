package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.model.AnnouncementType;
import com.xavier.pms.req.AnnouncementTypeDto;
import com.xavier.pms.resp.AnnouncementTypeVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 公告类型对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public abstract class AnnouncementTypeConvertor {

    public static AnnouncementType toAnnouncementType(AnnouncementTypeDto announcementTypeDto) {
        if (ObjectUtil.isNull(announcementTypeDto)) {
            return null;
        }
        return BeanUtil.beanCopy(announcementTypeDto, AnnouncementType.class);
    }

    public static AnnouncementTypeVo toAnnouncementTypeVo(AnnouncementType announcementType) {
        if (ObjectUtil.isNull(announcementType)) {
            return null;
        }
        return BeanUtil.beanCopy(announcementType, AnnouncementTypeVo.class);
    }

    public static List<AnnouncementTypeVo> toAnnouncementTypeVoList(List<AnnouncementType> announcementTypeList) {
        if (CollUtil.isEmpty(announcementTypeList)) {
            return new ArrayList<>();
        }
        List<AnnouncementTypeVo> announcementTypeInfoList = new ArrayList<>(announcementTypeList.size());
        for (AnnouncementType announcementType : announcementTypeList) {
            announcementTypeInfoList.add(toAnnouncementTypeVo(announcementType));
        }
        return announcementTypeInfoList;
    }

}
