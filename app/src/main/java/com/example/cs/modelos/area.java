package com.example.cs.modelos;

public class area {
    // Datos del área
    protected int id_area;
    protected String area;

    public area() {
        super();
    }

    public area(String value) {
        super();
        this.area = value;
    }

    public area(int id, String value) {
        super();
        this.id_area = id;
        this.area = value;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
