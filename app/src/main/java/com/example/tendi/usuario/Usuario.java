package com.example.tendi.usuario;

import com.example.tendi.model.Negocio;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String id;
    private String name;
    private String celular;
    private String contra;
    private boolean isTendero;

    public Usuario() {
    }

    public Usuario(String id, String name, String contra, String celular, boolean isTendero) {
        this.id = id;
        this.name = name;
        this.celular = celular;
        this.contra = contra;
        this.isTendero = isTendero;
    }

    public boolean isTendero() {
        return isTendero;
    }

    public void setTendero(boolean tendero) {
        isTendero = tendero;
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
