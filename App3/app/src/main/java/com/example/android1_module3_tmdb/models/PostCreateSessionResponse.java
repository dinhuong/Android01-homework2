package com.example.android1_module3_tmdb.models;

public class PostCreateSessionResponse {
    /**
     * success : true
     * session_id : 8fdd0159cda90004ec78e7184e8c9840ceff2a49
     */

    private boolean success;
    private String session_id;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}
