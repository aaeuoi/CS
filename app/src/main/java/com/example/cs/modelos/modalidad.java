package com.example.cs.modelos;

public class modalidad {
    // Datos del Modalidad
    protected int id_modalidad;
    protected String modalidad;

    public modalidad() {
        super();
    }

    public modalidad(String value) {
        super();
        this.modalidad = value;
    }

    public modalidad(int id, String value) {
        super();
        this.id_modalidad = id;
        this.modalidad = value;
    }

    public int getId_modalidad() {
        return id_modalidad;
    }

    public void setId_modalidad(int id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
}
