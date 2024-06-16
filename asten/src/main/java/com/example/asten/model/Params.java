package com.example.asten.model;

public class Params {
    private Envelope Envelope;
    private boolean gerarTags;
    private boolean encaminharImediatamente;
    private boolean detectarCampos;
    private boolean verificarDuplicidadeConteudo;
    private boolean processarImagensEmSegundoPlano;

    // Getters and Setters
    public Envelope getEnvelope() {
        return Envelope;
    }

    public void setEnvelope(Envelope envelope) {
        this.Envelope = envelope;
    }

    public boolean isGerarTags() {
        return gerarTags;
    }

    public void setGerarTags(boolean gerarTags) {
        this.gerarTags = gerarTags;
    }

    public boolean isEncaminharImediatamente() {
        return encaminharImediatamente;
    }

    public void setEncaminharImediatamente(boolean encaminharImediatamente) {
        this.encaminharImediatamente = encaminharImediatamente;
    }

    public boolean isDetectarCampos() {
        return detectarCampos;
    }

    public void setDetectarCampos(boolean detectarCampos) {
        this.detectarCampos = detectarCampos;
    }

    public boolean isVerificarDuplicidadeConteudo() {
        return verificarDuplicidadeConteudo;
    }

    public void setVerificarDuplicidadeConteudo(boolean verificarDuplicidadeConteudo) {
        this.verificarDuplicidadeConteudo = verificarDuplicidadeConteudo;
    }

    public boolean isProcessarImagensEmSegundoPlano() {
        return processarImagensEmSegundoPlano;
    }

    public void setProcessarImagensEmSegundoPlano(boolean processarImagensEmSegundoPlano) {
        this.processarImagensEmSegundoPlano = processarImagensEmSegundoPlano;
    }
}