package com.example.tendi.model;

public class Negocio {
    private String name;
    private String direction;
    private String rut;

    public Negocio() {
    }

    public Negocio(String name, String direction, String rut) {
        this.name = name;
        this.direction = direction;
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
