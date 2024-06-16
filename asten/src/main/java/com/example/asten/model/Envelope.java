package com.example.asten.model;

public class Envelope {
    private String descricao;
    private Repositorio Repositorio;
    private String usarOrdem;
    private ConfigAuxiliar ConfigAuxiliar;
    private ListaDocumentos listaDocumentos;
    private ListaSignatariosEnvelope listaSignatariosEnvelope;
    private ListaObservadores listaObservadores;
    private ListaTags listaTags;
    private ListaInfoAdicional listaInfoAdicional;
    private String incluirHashTodasPaginas;
    private String permitirDespachos;
    private String ignorarNotificacoes;
    private String ignorarNotificacoesPendentes;
    private String bloquearDesenhoPaginas;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public com.example.asten.model.Repositorio getRepositorio() {
        return Repositorio;
    }

    public void setRepositorio(com.example.asten.model.Repositorio repositorio) {
        Repositorio = repositorio;
    }

    public String getUsarOrdem() {
        return usarOrdem;
    }

    public void setUsarOrdem(String usarOrdem) {
        this.usarOrdem = usarOrdem;
    }

    public com.example.asten.model.ConfigAuxiliar getConfigAuxiliar() {
        return ConfigAuxiliar;
    }

    public void setConfigAuxiliar(com.example.asten.model.ConfigAuxiliar configAuxiliar) {
        ConfigAuxiliar = configAuxiliar;
    }

    public ListaDocumentos getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(ListaDocumentos listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public ListaSignatariosEnvelope getListaSignatariosEnvelope() {
        return listaSignatariosEnvelope;
    }

    public void setListaSignatariosEnvelope(ListaSignatariosEnvelope listaSignatariosEnvelope) {
        this.listaSignatariosEnvelope = listaSignatariosEnvelope;
    }

    public ListaObservadores getListaObservadores() {
        return listaObservadores;
    }

    public void setListaObservadores(ListaObservadores listaObservadores) {
        this.listaObservadores = listaObservadores;
    }

    public ListaTags getListaTags() {
        return listaTags;
    }

    public void setListaTags(ListaTags listaTags) {
        this.listaTags = listaTags;
    }

    public ListaInfoAdicional getListaInfoAdicional() {
        return listaInfoAdicional;
    }

    public void setListaInfoAdicional(ListaInfoAdicional listaInfoAdicional) {
        this.listaInfoAdicional = listaInfoAdicional;
    }

    public String getIncluirHashTodasPaginas() {
        return incluirHashTodasPaginas;
    }

    public void setIncluirHashTodasPaginas(String incluirHashTodasPaginas) {
        this.incluirHashTodasPaginas = incluirHashTodasPaginas;
    }

    public String getPermitirDespachos() {
        return permitirDespachos;
    }

    public void setPermitirDespachos(String permitirDespachos) {
        this.permitirDespachos = permitirDespachos;
    }

    public String getIgnorarNotificacoes() {
        return ignorarNotificacoes;
    }

    public void setIgnorarNotificacoes(String ignorarNotificacoes) {
        this.ignorarNotificacoes = ignorarNotificacoes;
    }

    public String getIgnorarNotificacoesPendentes() {
        return ignorarNotificacoesPendentes;
    }

    public void setIgnorarNotificacoesPendentes(String ignorarNotificacoesPendentes) {
        this.ignorarNotificacoesPendentes = ignorarNotificacoesPendentes;
    }

    public String getBloquearDesenhoPaginas() {
        return bloquearDesenhoPaginas;
    }

    public void setBloquearDesenhoPaginas(String bloquearDesenhoPaginas) {
        this.bloquearDesenhoPaginas = bloquearDesenhoPaginas;
    }
}
