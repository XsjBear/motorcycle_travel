package com.xiong.motorcycle_travel.ro;



import com.xiong.motorcycle_travel.constants.CommonCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 接口数据返回Ro
 * @author Xsj
 * @date 2021/10/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataRO<T> implements Serializable {

    /**
     * 结果编码
     */
    private int code = CommonCode.SUCCESS_CODE;

    /**
     * 结果描述
     */
    private String msg = "";

    /**
     * 接口返回内容
     */
    private T data = null;

    /**
     * 默认成功返回msg
     */
    public final static String DEFAULT_SUCCESS_MESSAGE = "请求成功";

    /**
     * 构造默认调用成功无返回值BO
     * @return 调用结果BO
     */
    public static <T> DataRO<T> buildSuccess() {
        return buildSuccess(null);
    }

    /**
     * 构造调用成功带返回值T的BO
     *
     * @param data 返回值
     * @param <T>  返回值类型
     * @return 调用结果BO
     */
    public static <T> DataRO<T> buildSuccess(T data) {
        return buildSuccess(DEFAULT_SUCCESS_MESSAGE, data);
    }

    /**
     * 构造调用成功带提示信息+返回值T的BO
     *
     * @param msg  提示信息
     * @param data 返回值
     * @param <T>  返回值类型
     * @return 调用结果BO
     */
    public static <T> DataRO<T> buildSuccess(String msg, T data) {
        return buildCommon(CommonCode.SUCCESS_CODE, msg, data);
    }


    /**
     * 用返回码+提示信息+返回值构造BO，用于指定通用码
     *
     * @param code 返回码
     * @param msg  提示信息
     * @param data 返回值
     * @param <T>  返回值类型
     * @return 调用结果BO
     */
    public static <T> DataRO<T> buildCommon(int code, String msg, T data) {
        return DataRO.<T>builder().code(code).msg(msg).data(data).build();
    }

    /**
     * 返回码+提示信息构造BO，用于指定通用码
     *
     * @param code 返回码
     * @param msg  提示信息
     * @param <T>  返回值类型
     * @return 调用结果BO
     */
    public static <T> DataRO<T> buildCommon(int code, String msg) {
        return buildCommon(code, msg, null);
    }

    /**
     * 客户端判断请求是否成功
     */
    public boolean isSuccess() {
        return code == CommonCode.SUCCESS_CODE;
    }
}
