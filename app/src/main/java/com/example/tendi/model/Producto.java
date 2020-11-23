package com.example.tendi.model;

import java.io.Serializable;

public class Producto implements Serializable {

    private String id;
    private String nombre;
    private int precio;
    private String img;

    public Producto(int precio, String name, String img) {

        this.id = "";
        this.precio = precio;
        this.nombre = name;
        this.img = img;

    }

    public Producto() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
