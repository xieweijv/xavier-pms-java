package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.model.Seal;
import com.xavier.pms.req.SealDto;
import com.xavier.pms.resp.SealVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 印章对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
public abstract class SealConvertor {

    public static SealVo toSealVo(Seal seal) {
        if (ObjectUtil.isNull(seal)) {
            return null;
        }
        return BeanUtil.beanCopy(seal, SealVo.class);
    }

    public static Seal toSeal(SealDto sealDto) {
        if (ObjectUtil.isNull(sealDto)) {
            return null;
        }
        return BeanUtil.beanCopy(sealDto, Seal.class);
    }

    public static List<SealVo> toSealVoList(List<Seal> sealList) {
        if (CollUtil.isEmpty(sealList)) {
            return new ArrayList<>();
        }
        List<SealVo> sealInfoList = new ArrayList<>(sealList.size());
        for (Seal seal : sealList) {
            sealInfoList.add(toSealVo(seal));
        }
        return sealInfoList;
    }

}
