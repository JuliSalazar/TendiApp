package com.example.tendi.model;

public class Producto {

    private String id;
    private String precio;

    public Producto(String id, String precio) {

        this.id = id;
        this.precio = precio;

    }

    public Producto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
