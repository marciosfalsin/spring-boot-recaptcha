package com.test.recaptcha.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class CaptchaResponse {

    private Boolean success;
    private Date timestamp;
    private String hostname;

    private String action; // v3
    private Float score; // v3

    @JsonProperty("error-codes")
    private List<String> errorCodes;

    public CaptchaResponse() {
    }

    public CaptchaResponse(Boolean success, Date timestamp, String hostname, List<String> errorCodes) {
        this.success = success;
        this.timestamp = timestamp;
        this.hostname = hostname;
        this.errorCodes = errorCodes;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
