package com.example.android1_module3_tmdb.models;

public class GetCreateRequestTokenResponse {

    /**
     * success : true
     * expires_at : 2020-04-27 15:26:20 UTC
     * request_token : cd62d74c7540b162e197cc6a06ffdcf2d0a908b6
     */

    private boolean success;
    private String expires_at;
    private String request_token;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    public String getRequest_token() {
        return request_token;
    }

    public void setRequest_token(String request_token) {
        this.request_token = request_token;
    }
}
