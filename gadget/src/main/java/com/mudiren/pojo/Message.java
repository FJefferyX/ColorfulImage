package com.mudiren.pojo;

public class Message {
    /*
     * 状态码：
     *       若为0：则表示正常；
     * */
    private String statusCode;
    private String errorMessage;
    private String data;

    public Message(String statusCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public Message(String statusCode, String errorMessage, String data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public Message() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "statusCode='" + statusCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
