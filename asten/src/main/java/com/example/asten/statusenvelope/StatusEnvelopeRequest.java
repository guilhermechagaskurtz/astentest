package com.example.asten.statusenvelope;

public class StatusEnvelopeRequest {
    private String token;
    private ParamsStatus params;

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ParamsStatus getParams() {
        return params;
    }

    public void setParams(ParamsStatus params) {
        this.params = params;
    }
}

