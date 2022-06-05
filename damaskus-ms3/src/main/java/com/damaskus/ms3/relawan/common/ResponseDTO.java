package com.damaskus.ms3.relawan.common;

import java.io.Serializable;

/**
 *
 * @author merlinthie
 */
public class ResponseDTO implements Serializable {

    private ResponseStatus status;
    private String code;
    private String message;
    private Long version;

    public ResponseDTO() {
    }

    public ResponseDTO(ResponseStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.version = 0L;
    }
    
    public ResponseDTO(ResponseStatus status, String code, String message, Long version) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.version = version;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ResponseDTO defaultResponse() {
        ResponseDTO response = new ResponseDTO();
        response.setStatus(ResponseStatus.S);
        response.setCode("201");
        response.setMessage("Process Successed");
        response.setVersion(0L);
        return response;
    }
    
    public ResponseDTO defaultResponse(Long version) {
        ResponseDTO response = new ResponseDTO();
        response.setStatus(ResponseStatus.S);
        response.setCode("201");
        response.setMessage("Process Successed");
        response.setVersion(version);
        return response;
    }

    public ResponseDTO noDataFoundResponse() {
        ResponseDTO response = new ResponseDTO();
        response.setStatus(ResponseStatus.S);
        response.setCode("204");
        response.setMessage("No data Found");
        response.setVersion(0L);
        return response;
    }

    public ResponseDTO failedRespose(String code, String message) {
        ResponseDTO response = new ResponseDTO();
        response.setStatus(ResponseStatus.F);
        response.setCode(code);
        response.setMessage(message);
        response.setVersion(0L);
        return response;
    }
}
