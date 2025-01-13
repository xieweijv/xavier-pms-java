package com.xavier.pms.convertor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.model.Car;
import com.xavier.pms.req.CarDto;
import com.xavier.pms.resp.CarVo;
import com.xavier.pms.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 车辆对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public abstract class CarConvertor {

    public static CarVo toCarVo(Car car) {
        if (ObjectUtil.isNull(car)) {
            return null;
        }
        return BeanUtil.beanCopy(car, CarVo.class);
    }

    public static Car toCar(CarDto carDto) {
        if (ObjectUtil.isNull(carDto)) {
            return null;
        }
        return BeanUtil.beanCopy(carDto, Car.class);
    }

    public static List<CarVo> toCarVoList(List<Car> carList) {
        if (CollUtil.isEmpty(carList)) {
            return new ArrayList<>();
        }
        List<CarVo> carInfoList = new ArrayList<>(carList.size());
        for (Car car : carList) {
            carInfoList.add(toCarVo(car));
        }
        return carInfoList;
    }

}
