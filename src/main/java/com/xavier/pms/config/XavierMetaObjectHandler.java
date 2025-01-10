package com.xavier.pms.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.xavier.pms.resp.UserInfoVo;
import com.xavier.pms.utils.UserContainer;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class XavierMetaObjectHandler implements MetaObjectHandler {
    public XavierMetaObjectHandler() {
    }

    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        UserInfoVo vo = UserContainer.get();
        if (Objects.nonNull(vo)) {
            this.strictInsertFill(metaObject, "createUserId", Long.class, vo.getId());
            this.strictInsertFill(metaObject, "createNickName", String.class, vo.getNickName());
        }
    }

    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        UserInfoVo userInfoVO = UserContainer.get();
        if (Objects.nonNull(userInfoVO)) {
            this.strictUpdateFill(metaObject, "updateUser", Long.class, userInfoVO.getId());
            this.strictUpdateFill(metaObject, "updateNickName", String.class, userInfoVO.getNickName());
        }
    }
}