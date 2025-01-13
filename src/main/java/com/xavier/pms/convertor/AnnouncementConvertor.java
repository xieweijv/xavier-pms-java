package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.model.Announcement;
import com.xavier.pms.req.AnnouncementDto;
import com.xavier.pms.resp.AnnouncementVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 公告对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public abstract class AnnouncementConvertor {

    public static Announcement toAnnouncement(AnnouncementDto announcementDto) {
        if (ObjectUtil.isNull(announcementDto)) {
            return null;
        }
        return BeanUtil.beanCopy(announcementDto, Announcement.class);
    }

    public static AnnouncementVo toAnnouncementVo(Announcement announcement) {
        if (ObjectUtil.isNull(announcement)) {
            return null;
        }
        return BeanUtil.beanCopy(announcement, AnnouncementVo.class);
    }

    public static List<AnnouncementVo> toAnnouncementVoList(List<Announcement> announcementList) {
        if (CollUtil.isEmpty(announcementList)) {
            return new ArrayList<>();
        }
        List<AnnouncementVo> announcementInfoList = new ArrayList<>(announcementList.size());
        for (Announcement announcement : announcementList) {
            announcementInfoList.add(toAnnouncementVo(announcement));
        }
        return announcementInfoList;
    }

}
