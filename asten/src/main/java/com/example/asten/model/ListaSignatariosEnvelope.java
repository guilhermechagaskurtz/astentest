package com.example.asten.model;

import java.util.List;

public class ListaSignatariosEnvelope {
    private List<SignatarioEnvelope> SignatarioEnvelope;

    // Getters and Setters
    public List<SignatarioEnvelope> getSignatarioEnvelope() {
        return SignatarioEnvelope;
    }

    public void setSignatarioEnvelope(List<SignatarioEnvelope> signatarioEnvelope) {
        SignatarioEnvelope = signatarioEnvelope;
    }
}
