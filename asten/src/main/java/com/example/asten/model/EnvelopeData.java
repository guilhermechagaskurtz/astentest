package com.example.asten.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EnvelopeData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int idEnvelope;
    private String incluirDocs;
    private String nomeArquivo;
    private String mimeType;
    private String conteudo;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}

