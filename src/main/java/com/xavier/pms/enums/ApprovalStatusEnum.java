package com.xavier.pms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Comments: 审批状态枚举
 */
@Getter
@AllArgsConstructor
public enum ApprovalStatusEnum {
    UNPUBLISHED              ((byte) 0, "未发布"),
    NORMAL                   ((byte) 1, "正常"),
    DEACTIVATE               ((byte) 2, "停用"),
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
        for (ApprovalStatusEnum element : ApprovalStatusEnum.values()) {
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
        for (ApprovalStatusEnum element : ApprovalStatusEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }
}
