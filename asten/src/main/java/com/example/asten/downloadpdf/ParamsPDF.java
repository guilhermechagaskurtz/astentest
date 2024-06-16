package com.example.asten.downloadpdf;

public class ParamsPDF {
    private int idEnvelope;
    private String incluirDocs;
    private String versaoSemCertificado;

    // Getters and Setters
    public int getIdEnvelope() {
        return idEnvelope;
    }

    public void setIdEnvelope(int idEnvelope) {
        this.idEnvelope = idEnvelope;
    }

    public String getIncluirDocs() {
        return incluirDocs;
    }

    public void setIncluirDocs(String incluirDocs) {
        this.incluirDocs = incluirDocs;
    }

    public String getVersaoSemCertificado() {
        return versaoSemCertificado;
    }

    public void setVersaoSemCertificado(String versaoSemCertificado) {
        this.versaoSemCertificado = versaoSemCertificado;
    }
}
