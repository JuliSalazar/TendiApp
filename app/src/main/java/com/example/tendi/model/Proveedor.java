package com.example.tendi.model;

import java.io.Serializable;

public class Proveedor implements Serializable {

    private String id;
    private String nombre;
    private int precioUnidad;
    private int precioDocena;
    private int precioCargo;
    private String img;

    public Proveedor( String nombre, int precioUnidad, int precioDocena, int precioCargo, String img) {
        this.id = "";
        this.nombre = nombre;
        this.precioUnidad = precioUnidad;
        this.precioDocena = precioDocena;
        this.precioCargo = precioCargo;
        this.img = img;
    }

    public Proveedor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getPrecioDocena() {
        return precioDocena;
    }

    public void setPrecioDocena(int precioDocena) {
        this.precioDocena = precioDocena;
    }

    public int getPrecioCargo() {
        return precioCargo;
    }

    public void setPrecioCargo(int precioCargo) {
        this.precioCargo = precioCargo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
