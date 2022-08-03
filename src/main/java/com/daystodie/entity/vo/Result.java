package com.daystodie.entity.vo;

import com.daystodie.exception.BaseExceptionEnum;
import com.daystodie.exception.SuperEnumFace;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;

/**
 * 统一响应结果
 *
 * @author leaf
 */
@Data
@AllArgsConstructor
public class Result<T> implements Serializable {
    /**
     * 状态码
     */
    private int code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(SuperEnumFace superEnumFace) {
        this.code = superEnumFace.getCode();
        this.message = superEnumFace.getMessage();
    }

    public Result(SuperEnumFace superEnumFace, T data) {
        this.code = superEnumFace.getCode();
        this.message = superEnumFace.getMessage();
        this.data = data;
    }

    /**
     * 服务器错误
     *
     * @param message
     * @return
     */
    public static Result error(String message) {
        if (ObjectUtils.isEmpty(message)) {
            return new Result(BaseExceptionEnum.ERROR);
        } else {
            return new Result(BaseExceptionEnum.ERROR.getCode(), message);
        }
    }

    /**
     * @param data
     * @return
     */
    public static <T> Result success(T data) {
        return new Result(BaseExceptionEnum.SUCCESS, data);
    }
}
