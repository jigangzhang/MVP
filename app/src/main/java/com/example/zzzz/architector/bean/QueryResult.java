package com.example.zzzz.architector.bean;

public class QueryResult<T> {

    private static final long serialVersionUID = 1L;
    private boolean success; // 是否成功
    private String exceptionMessage; // 错误信息
    private String exceptionCode; // 错误码
    private String successMessage; // 返回提示信息
    private T result; // 实体数据

    public QueryResult() {
        super();
    }

    public QueryResult(boolean success, String exceptionMessage, String exceptionCode,
                       String successMessage, T result) {
        this.success = success;
        this.exceptionMessage = exceptionMessage;
        this.exceptionCode = exceptionCode;
        this.successMessage = successMessage;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "success=" + success +
                ", exceptionMessage='" + exceptionMessage + '\'' +
                ", exceptionCode='" + exceptionCode + '\'' +
                ", successMessage='" + successMessage + '\'' +
                ", result=" + result +
                '}';
    }
}
