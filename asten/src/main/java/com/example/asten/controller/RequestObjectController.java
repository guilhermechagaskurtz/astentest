package com.example.asten.controller;

import com.example.asten.downloadpdf.DownloadPDFRequest;
import com.example.asten.downloadpdf.DownloadPDFResponse;
import com.example.asten.model.ResponseData;
import com.example.asten.statusenvelope.StatusEnvelopeRequest;
import com.example.asten.statusenvelope.StatusEnvelopeResponse;
import com.example.asten.service.RequestObjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "API de gerenciamento de envelopes", tags = {"API de Envelopes"})
public class RequestObjectController {
    private final RequestObjectService requestObjectService;

    @Autowired
    public RequestObjectController(RequestObjectService requestObjectService) {
        this.requestObjectService = requestObjectService;
    }

    @PostMapping("/sendRequest")
    @ApiOperation(value = "Enviar requisição", notes = "Envia uma requisição para criar um envelope")
    public ResponseEntity<ResponseData> sendRequest() {
        System.out.println("Recebi uma chamada");
        ResponseData responseData = requestObjectService.sendPostRequest();
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


    @PostMapping("/downloadPDFEnvelopeDocs")
    @ApiOperation(value = "Download de PDF do Envelope", notes = "Faz o download do PDF do envelope e salva os dados no banco de dados")
    public ResponseEntity<DownloadPDFResponse> downloadPDFEnvelopeDocs(@RequestBody DownloadPDFRequest request) {
        try {
            if (request.getParams() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            int idEnvelope = request.getParams().getIdEnvelope();
            String incluirDocs = request.getParams().getIncluirDocs();
            DownloadPDFResponse response = requestObjectService.downloadPDFEnvelopeDocs(idEnvelope, incluirDocs);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/consultarStatusEnvelope")
    @ApiOperation(value = "Consultar Status do Envelope", notes = "Consulta o status do envelope")
    public ResponseEntity<StatusEnvelopeResponse> consultarStatusEnvelope(@RequestBody StatusEnvelopeRequest request) {
        try {
            if (request.getParams() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            int idEnvelope = request.getParams().getIdEnvelope();
            String getLobs = request.getParams().getGetLobs();
            StatusEnvelopeResponse response = requestObjectService.consultarStatusEnvelope(idEnvelope, getLobs);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/teste")
    public void teste() {
        System.out.println("oi");
    }
}
