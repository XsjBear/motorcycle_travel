package com.xiong.motorcycle_travel.error;

/**
 * @Description:业务异常类
 * @Author Xsj 2021/10/11  11:15
 **/
public class BusinessException extends RuntimeException {

    /**
     * 错误代码
     */
    protected long errorCode;

    /**
     * 异常描述
     */
    protected String errorMessage;

    public BusinessException() {
    }

    public BusinessException(long errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
