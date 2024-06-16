package com.example.asten.statusenvelope;

public class StatusEnvelopeResponse {
    private Response response;

    // Getters and Setters

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response {
        private String id;
        private Repositorio repositorio;
        private Usuario usuario;
        private String descricao;
        private String conteudo;
        private String incluirHashTodasPaginas;
        private String permitirDespachos;
        private String usarOrdem;
        private String hashSHA256;
        private String hashSHA512;
        private String mensagem;
        private String mensagemObservadores;
        private String motivoCancelamento;
        private String numeroPaginas;
        private String status;
        private String dataEnvioAgendado;
        private String horaEnvioAgendado;
        private String dataHoraCriacao;
        private String dataHoraAlteracao;
        private String dataHoraConclusao;
        private String dataHoraCancelamento;
        private String dataHoraArquivamento;
        private String dataIniContrato;
        private String dataFimContrato;
        private String objetoContrato;
        private String numContrato;
        private String valorContrato;
        private String descricaoContratante;
        private String descricaoContratado;

        // Getters and Setters
        // (Adicionar todos os getters e setters aqui)
    }
}
