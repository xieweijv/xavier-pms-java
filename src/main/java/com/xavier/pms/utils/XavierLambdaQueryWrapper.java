package com.xavier.pms.utils;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * 拓展 MyBatisPlus QueryWrapper 类
 */
public class XavierLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {

    public XavierLambdaQueryWrapper<T> likeIfPresent(SFunction<T, ?> column, String val) {
        if (StringUtils.hasText(val)) {
            return (XavierLambdaQueryWrapper<T>) super.like(column, val);
        }
        return this;
    }

    public XavierLambdaQueryWrapper<T> inIfPresent(SFunction<T, ?> column, Collection<?> values) {
        if (ObjectUtil.isAllNotEmpty(values) && !ArrayUtil.isEmpty(values)) {
            return (XavierLambdaQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public XavierLambdaQueryWrapper<T> inIfPresent(SFunction<T, ?> column, Object... values) {
        if (ObjectUtil.isAllNotEmpty(values) && !ArrayUtil.isEmpty(values)) {
            return (XavierLambdaQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public XavierLambdaQueryWrapper<T> eqIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtil.isNotEmpty(val)) {
            return (XavierLambdaQueryWrapper<T>) super.eq(column, val);
        }
        return this;
    }

    public XavierLambdaQueryWrapper<T> neIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtil.isNotEmpty(val)) {
            return (XavierLambdaQueryWrapper<T>) super.ne(column, val);
        }
        return this;
    }

    public XavierLambdaQueryWrapper<T> gtIfPresent(SFunction<T, ?> column, Object val) {
        if (val != null) {
            return (XavierLambdaQueryWrapper<T>) super.gt(column, val);
        }
        return this;
    }

    public XavierLambdaQueryWrapper<T> geIfPresent(SFunction<T, ?> column, Object val) {
        if (val != null) {
            return (XavierLambdaQueryWrapper<T>) super.ge(column, val);
        }
        return this;
    }

    public XavierLambdaQueryWrapper<T> ltIfPresent(SFunction<T, ?> column, Object val) {
        if (val != null) {
            return (XavierLambdaQueryWrapper<T>) super.lt(column, val);
        }
        return this;
    }

    public XavierLambdaQueryWrapper<T> leIfPresent(SFunction<T, ?> column, Object val) {
        if (val != null) {
            return (XavierLambdaQueryWrapper<T>) super.le(column, val);
        }
        return this;
    }

    public XavierLambdaQueryWrapper<T> betweenIfPresent(SFunction<T, ?> column, Object val1, Object val2) {
        if (val1 != null && val2 != null) {
            return (XavierLambdaQueryWrapper<T>) super.between(column, val1, val2);
        }
        if (val1 != null) {
            return (XavierLambdaQueryWrapper<T>) ge(column, val1);
        }
        if (val2 != null) {
            return (XavierLambdaQueryWrapper<T>) le(column, val2);
        }
        return this;
    }


}
