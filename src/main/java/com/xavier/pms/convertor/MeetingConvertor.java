package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.model.Meeting;
import com.xavier.pms.req.MeetingDto;
import com.xavier.pms.resp.MeetingVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 会议室对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public abstract class MeetingConvertor {

    public static MeetingVo toMeetingVo(Meeting meeting) {
        if (ObjectUtil.isNull(meeting)) {
            return null;
        }
        return BeanUtil.beanCopy(meeting, MeetingVo.class);
    }

    public static Meeting toMeeting(MeetingDto meetingDto) {
        if (ObjectUtil.isNull(meetingDto)) {
            return null;
        }
        return BeanUtil.beanCopy(meetingDto, Meeting.class);
    }

    public static List<MeetingVo> toMeetingVoList(List<Meeting> meetingList) {
        if (CollUtil.isEmpty(meetingList)) {
            return new ArrayList<>();
        }
        List<MeetingVo> meetingInfoList = new ArrayList<>(meetingList.size());
        for (Meeting meeting : meetingList) {
            meetingInfoList.add(toMeetingVo(meeting));
        }
        return meetingInfoList;
    }

}
