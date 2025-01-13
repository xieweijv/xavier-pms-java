package com.xavier.pms.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Component;

@Component
public class XavierIdentifierGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        return YitIdHelper.nextId();
    }
}