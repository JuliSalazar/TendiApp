package com.example.tendi.model;

import java.io.Serializable;

public class Comprador implements Serializable {
    private String id;
    private String name;
    private String celular;
    private String contra;


    public Comprador() {
    }

    public Comprador(String id, String name, String contra, String celular) {
        this.id = id;
        this.name = name;
        this.celular = celular;
        this.contra = contra;

    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
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
}
