package com.xavier.pms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Comments: 审批单状态枚举
 */
@Getter
@AllArgsConstructor
public enum AuditStatusEnum {
    PENDING                  ((byte) 1, "待处理"),
    SUBMITTED                ((byte) 2, "已提交"),
    UNDER                    ((byte) 3, "审批中"),
    PASSED                   ((byte) 4, "已通过"),
    REJECTED                 ((byte) 5, "已拒绝"),
    WITHDRAWN                ((byte) 6, "已撤回"),
    CC                       ((byte) 7, "自动抄送"),
    ;

    private final byte value;
    private final String desc;

    public static boolean exists(Byte status) {
        if (status == null) {
            return false;
        }
        byte s = status.byteValue();
        return exists(s);
    }

    public static boolean exists(byte s) {
        for (AuditStatusEnum element : AuditStatusEnum.values()) {
            if (element.value == s) {
                return true;
            }
        }
        return false;
    }

    public boolean equal(Byte val) {
        return val == null ? false : val.byteValue() == this.value;
    }

    public static String getDescByValue(Byte value) {
        if (value == null) {
            return "";
        }
        for (AuditStatusEnum element : AuditStatusEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }
}
