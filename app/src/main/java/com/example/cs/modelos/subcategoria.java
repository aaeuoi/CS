package com.example.cs.modelos;

public class subcategoria {
    // Datos de la subcategoria
    protected int id_subcategoria;
    protected String subcategoria;
    protected int id_categoria;

    public subcategoria() {
        super();
    }

    public subcategoria(String value, int id_categoria) {
        super();
        this.subcategoria = value;
        this.id_categoria = id_categoria;
    }

    public subcategoria(int id, String value, int id_categoria) {
        super();
        this.id_subcategoria = id;
        this.subcategoria = value;
        this.id_categoria = id_categoria;
    }

    public int getId_subcategoria() {
        return id_subcategoria;
    }

    public void setId_subcategoria(int id_subcategoria) {
        this.id_subcategoria = id_subcategoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
