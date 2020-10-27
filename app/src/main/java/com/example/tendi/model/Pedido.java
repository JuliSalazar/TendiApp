package com.example.tendi.model;

public class Pedido {
    private String name;
    private String id;
    private String producto;
    public Pedido() {
    }

    public Pedido(String id, String name, String producto) {
        this.name = name;
        this.id = id;
        this.producto = producto;
    }
}
