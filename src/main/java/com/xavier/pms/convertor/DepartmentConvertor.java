package com.xavier.pms.convertor;

import cn.hutool.core.util.ObjectUtil;
import com.xavier.pms.model.Department;
import com.xavier.pms.req.DepartmentDto;
import com.xavier.pms.resp.DepartmentVo;
import com.xavier.pms.utils.BeanUtil;

/**
 * 部门对象相互转换
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public abstract class DepartmentConvertor {

    public static DepartmentVo toDepartmentVo(Department department) {
        if (ObjectUtil.isNull(department)) {
            return null;
        }
        return BeanUtil.beanCopy(department, DepartmentVo.class);
    }

    public static Department toDepartment(DepartmentDto departmentDto) {
        if (ObjectUtil.isNull(departmentDto)) {
            return null;
        }
        return BeanUtil.beanCopy(departmentDto, Department.class);
    }

}
