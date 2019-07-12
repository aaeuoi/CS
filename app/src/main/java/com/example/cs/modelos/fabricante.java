package com.example.cs.modelos;

public class fabricante {
    // Datos del fabricante
    protected int id_fabricante;
    protected String fabricante;

    public fabricante() {
        super();
    }

    public fabricante(String value) {
        super();
        this.fabricante = value;
    }

    public fabricante(int id, String value) {
        super();
        this.id_fabricante = id;
        this.fabricante = value;
    }

    public int getId_fabricante() {
        return id_fabricante;
    }

    public void setId_fabricante(int id_fabricante) {
        this.id_fabricante = id_fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

}
