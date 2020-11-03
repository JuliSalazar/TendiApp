package com.example.tendi.model;

import java.io.Serializable;

public class Tendero implements Serializable {
    private String id;
    private String name;
    private String celular;
    private String contra;
    private Negocio negocio;

    public Tendero() {
    }

    public Tendero(String id, String name, String celular) {
        this.id = id;
        this.name = name;
        this.celular = celular;
        this.contra = contra;
        this.negocio = negocio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }
}
