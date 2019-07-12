package com.example.cs.modelos;

public class categoria {
    // Datos de la Categoria
    protected int id_categoria;
    protected String categoria;
    protected int id_area;

    public categoria() {
        super();
    }

    public categoria(String value, int id_area) {
        super();
        this.categoria = value;
        this.id_area = id_area;
    }

    public categoria(int id, String value, int id_area) {
        super();
        this.id_categoria = id;
        this.categoria = value;
        this.id_area = id_area;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }
}
