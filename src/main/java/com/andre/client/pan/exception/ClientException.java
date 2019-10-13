package com.andre.client.pan.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;


public class ClientException extends RuntimeException {
    private int httpStatus;
    private String errorCode;
    private Map<String, String> fields;

    public ClientException(int httpStatus, String errorCode, String description) {
        super(description);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public ClientException(int httpStatus, String errorCode, String description, Throwable cause) {
        super(description, cause);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;

    }

    public ClientException(int httpStatus, String errorCode, String description, Map<String, String> fields, Throwable cause) {
        super(description, cause);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.fields = fields;
    }


    public int getHttpStatus() {
        return httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("httpStatus", httpStatus)
                .append("errorCode", errorCode)
                .append("fields", fields)
                .build();
    }

}
