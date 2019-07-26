package com.example.cs.modelos;

public class modalidad {
    // Datos del Modalidad
    protected int id_modalidad;
    protected String mmdalidad;

    public modalidad() {
        super();
    }

    public modalidad(String value) {
        super();
        this.mmdalidad = value;
    }

    public modalidad(int id, String value) {
        super();
        this.id_modalidad = id;
        this.mmdalidad = value;
    }

    public int getId_modalidad() {
        return id_modalidad;
    }

    public void setId_modalidad(int id_modalidad) {
        this.id_modalidad = id_modalidad;
    }
/*
    public String getModalidad() { return cas_modalidad;    }

    public void setModalidad(String modalidad) {       this.cas_modalidad = modalidad;   }
*/
    public String getModalidad() {        return mmdalidad;    }

    public void setModalidad(String modalidad) {        this.mmdalidad = modalidad;    }
}
