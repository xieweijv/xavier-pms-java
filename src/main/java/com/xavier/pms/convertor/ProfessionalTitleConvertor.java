package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.model.ProfessionalTitle;
import com.xavier.pms.req.ProfessionalTitleDto;
import com.xavier.pms.resp.ProfessionalTitleVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 职称对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
public abstract class ProfessionalTitleConvertor {

    public static ProfessionalTitleVo toProfessionalTitleVo(ProfessionalTitle professionalTitle) {
        if (ObjectUtil.isNull(professionalTitle)) {
            return null;
        }
        return BeanUtil.beanCopy(professionalTitle, ProfessionalTitleVo.class);
    }

    public static ProfessionalTitle toProfessionalTitle(ProfessionalTitleDto professionalTitleDto) {
        if (ObjectUtil.isNull(professionalTitleDto)) {
            return null;
        }
        return BeanUtil.beanCopy(professionalTitleDto, ProfessionalTitle.class);
    }

    public static List<ProfessionalTitleVo> toProfessionalTitleVoList(List<ProfessionalTitle> professionalTitleList) {
        if (CollUtil.isEmpty(professionalTitleList)) {
            return new ArrayList<>();
        }
        List<ProfessionalTitleVo> professionalTitleInfoList = new ArrayList<>(professionalTitleList.size());
        for (ProfessionalTitle professionalTitle : professionalTitleList) {
            professionalTitleInfoList.add(toProfessionalTitleVo(professionalTitle));
        }
        return professionalTitleInfoList;
    }

}
