package com.example.cs.modelos;

import java.util.Date;

public class convocatoria {
    // Datos de la tabla convocatoria
    protected int    id;// pku
    protected String cas_sku;
    protected Date   cas_inicio;//del curso
    protected String cas_horario;
    protected String cas_lugar; // dónde se imparte el curso
    protected String cas_modalidad;

    public convocatoria() {
        super();
    }

    public convocatoria(int v0, String v1, Date v2, String v3, String v4, String v5) {
        super();
        this.id = v0;
        this.cas_sku = v1;
        this.cas_inicio = v2;
        this.cas_horario = v3;
        this.cas_lugar = v4;
        this.cas_modalidad = v5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return cas_sku;
    }

    public void setSku(String sku) {
        this.cas_sku = sku;
    }

    public Date getInicio() {
        return cas_inicio;
    }

    public void setInicio(Date inicio) {
        this.cas_inicio = inicio;
    }

    public String getHorario() {
        return cas_horario;
    }

    public void setHorario(String horario) {
        this.cas_horario = horario;
    }

    public String getLugar() {
        return cas_lugar;
    }

    public void setLugar(String lugar) {
        this.cas_lugar = lugar;
    }

    public String getModalidad() {
        return cas_modalidad;
    }

    public void setModalidad(String modalidad) {
        this.cas_modalidad = modalidad;
    }
}
