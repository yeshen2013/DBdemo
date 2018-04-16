package com.lyyexample.common;

/**
 * Created by liuyangyang on 2018/4/15.
 */
public class ResponseModel<T> {

    private String retCode;

    private String retMsg;

    private T retContent;

    public ResponseModel(T obj){
        this.retCode = "200";
        this.retMsg = "成功";
        this.retContent = obj;
    }

    public ResponseModel(String retCode, String retMsg){
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public void setRetContent(T retContent) {
        this.retContent = retContent;
    }

    public String getRetCode() {
        return retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public T getRetContent() {
        return retContent;
    }

    public static <T> ResponseModel ok(T t){
        return new ResponseModel(t);
    }

    public static ResponseModel fail(String retCode, String retMsg){
        return new ResponseModel(retCode, retMsg);
    }

    public static ResponseModel fail(String retMsg){
        return new ResponseModel(StatusCode.FAIL.statusCode, retMsg);
    }

    public static ResponseModel ok(){
        return new ResponseModel(StatusCode.SUCCESS.statusCode, StatusCode.SUCCESS.statusMessage);
    }

    public static ResponseModel fail(){
        return new ResponseModel(StatusCode.FAIL.statusCode, StatusCode.FAIL.statusMessage);
    }

    public enum StatusCode{
        SUCCESS("200","成功"),FAIL("400","失败"),DENY("401","deny");

        private String statusCode;
        private String statusMessage;

        StatusCode(String statusCode, String statusMessage){
            this.statusCode = statusCode;
            this.statusMessage = statusMessage;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusMessage() {
            return statusMessage;
        }

        public void setStatusMessage(String statusMessage) {
            this.statusMessage = statusMessage;
        }
    }


}
