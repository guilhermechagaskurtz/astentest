package com.example.asten.downloadpdf;

public class Response {
    private String envelopeContent;
    private String nomeArquivo;
    private String mimeType;

    // Getters and Setters

    public String getEnvelopeContent() {
        return envelopeContent;
    }

    public void setEnvelopeContent(String envelopeContent) {
        this.envelopeContent = envelopeContent;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
