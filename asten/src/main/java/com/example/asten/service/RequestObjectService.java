package com.example.asten.service;

import com.example.asten.downloadpdf.DownloadPDFResponse;
import com.example.asten.model.ResponseData;
import com.example.asten.repository.EnvelopeDataRepository;
import com.example.asten.statusenvelope.StatusEnvelopeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RequestObjectService {


    private final RestTemplate restTemplate;
    private final EnvelopeDataRepository envelopeDataRepository;

    @Autowired
    public RequestObjectService(RestTemplate restTemplate, EnvelopeDataRepository envelopeDataRepository) {
        this.restTemplate = restTemplate;
        this.envelopeDataRepository = envelopeDataRepository;
    }

    public ResponseData sendPostRequest() {
        /*String url = "https://plataforma.astenassinatura.com.br/api/nomeDoServico";  // URL do servidor de destino

        RequestObject requestObject = new RequestObject();
        requestObject.setToken("56ht9p-Li8k5zHaQ2Dzxzijr...");
        Params params = new Params();
        // Set other fields as per the JSON structure
        requestObject.setParams(params);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RequestObject> request = new HttpEntity<>(requestObject, headers);

        ResponseEntity<ResponseData> response = restTemplate.postForEntity(url, request, ResponseData.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to send request: " + response.getStatusCode());
        }*/
        throw new RuntimeException("Not implemented yet");
    }

    public DownloadPDFResponse downloadPDFEnvelopeDocs(int idEnvelope, String incluirDocs) {
        /*String url = "http://external-api.com/downloadPDFEnvelopeDocs"; // URL da API externa
        String token = "56ht9p-Li8k5zHaQ2Dzxzijr..."; // Token fixo

        DownloadPDFRequest request = new DownloadPDFRequest();
        request.setToken(token);
        ParamsPDF params = new ParamsPDF();
        params.setIdEnvelope(idEnvelope);
        params.setIncluirDocs(incluirDocs);
        request.setParams(params);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<DownloadPDFRequest> httpEntity = new HttpEntity<>(request, headers);

        ResponseEntity<DownloadPDFResponse> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, DownloadPDFResponse.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // Salvar os dados no banco de dados
            EnvelopeData envelopeData = new EnvelopeData();
            envelopeData.setIdEnvelope(idEnvelope);
            envelopeData.setIncluirDocs(incluirDocs);
            envelopeData.setNomeArquivo(response.getBody().getResponse().getNomeArquivo());
            envelopeData.setMimeType(response.getBody().getResponse().getMimeType());
            envelopeData.setConteudo(response.getBody().getResponse().getEnvelopeContent());

            envelopeDataRepository.save(envelopeData);
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to download PDF: " + response.getStatusCode());
        }*/
        throw new RuntimeException("Download PDF not implemented yet");
    }

    public StatusEnvelopeResponse consultarStatusEnvelope(int idEnvelope, String getLobs) {
        /*String url = "http://external-api.com/getDadosEnvelope"; // URL da API externa
        String token = "56ht9p-Li8k5zHaQ2Dzxzijr..."; // Token fixo

        StatusEnvelopeRequest request = new StatusEnvelopeRequest();
        request.setToken(token);
        ParamsStatus params = new ParamsStatus();
        params.setIdEnvelope(idEnvelope);
        params.setGetLobs(getLobs);
        request.setParams(params);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<StatusEnvelopeRequest> httpEntity = new HttpEntity<>(request, headers);

        ResponseEntity<StatusEnvelopeResponse> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, StatusEnvelopeResponse.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to consult status: " + response.getStatusCode());
        }*/
        throw new RuntimeException("Consultar Status not implemented yet");
    }
}
