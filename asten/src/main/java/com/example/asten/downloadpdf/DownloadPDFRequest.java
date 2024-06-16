package com.example.asten.downloadpdf;

public class DownloadPDFRequest {
    private String token;
    private ParamsPDF params;

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ParamsPDF getParams() {
        return params;
    }

    public void setParams(ParamsPDF params) {
        this.params = params;
    }
}
