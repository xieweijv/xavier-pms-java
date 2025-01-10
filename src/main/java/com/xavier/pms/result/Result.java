package com.xavier.pms.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Schema(description = "请求结果")
@Getter
@Setter
@NoArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "操作标识")
    private Boolean success = Boolean.TRUE;
    @Schema(description = "结果代码")
    private Integer code = ResultCode.SUCCESS.code;
    @Schema(description = "错误说明")
    private String msg = "";
    @Schema(description = "结果对象")
    private T data;
    @Schema(description = "当前时间戳")
    private Long timestamp;

    public Result(int code, String msg, boolean success, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setSuccess(success);
        this.setData(data);
    }

    public Result(int code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setSuccess(code == 200);
        this.setData(data);
    }

    /**
     * 构建返回对象实例
     */
    public static <T> Result<T> ok(ResultCode resultCode, boolean success, T value) {
        return new Result<T>(resultCode.code, resultCode.desc, success, value);
    }

    /**
     * 构建成功对象实例
     */
    public static <T> Result<T> ok() {
        return new Result<T>(ResultCode.SUCCESS.code,
                ResultCode.SUCCESS.desc, true, null);
    }

    /**
     * 构建成功对象实例
     */
    public static <T> Result<T> ok(T value) {
        return new Result<T>(ResultCode.SUCCESS.code,
                ResultCode.SUCCESS.desc, true, value);
    }

    public static <T> Result<T> ok(T data, String message) {
        return new Result<T>(ResultCode.SUCCESS.code, message, true, data);
    }

    public static <T> Result<T> error(String message) {
        return new Result<T>(ResultCode.COMMON_MESSAGE.code, message, false, null);
    }

    /**
     * 构建错误对象
     *
     * @param errorCode
     * @return
     */

    public static <T> Result<T> error(ResultCode errorCode) {
        return new Result<T>(errorCode.code, errorCode.desc, false, null);
    }

    public static <T> Result<T> error(int code, String message, Object... args) {
        Result<T> r = new Result<T>(code, "", false, null);
        r.setFormatMessage(message, args);
        return r;
    }

    public static <T> Result<T> error(ResultCode resultCode, Object... args) {
        Result<T> r = new Result<T>(resultCode.getCode(), "", false, null);
        r.setFormatMessage(resultCode.getDesc(), args);

        return r;
    }

    public void setFormatMessage(String message, Object... args) {
        if (args == null || args.length == 0) {
            this.setMsg(message);
        } else {
            this.setMsg(String.format(message, args));
        }
    }

    public Long getTimestamp() {
        return timestamp == null ? System.currentTimeMillis() : timestamp;
    }

}
