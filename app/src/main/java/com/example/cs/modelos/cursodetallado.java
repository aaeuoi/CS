package com.example.cs.modelos;

import java.lang.ref.SoftReference;

public class cursodetallado {

    // Datos del cursodetallado
    protected String cas_area;
    protected String cas_categoria;
    protected String cas_subcategoria;
    protected String cas_sku; // pku
    protected String cas_nombre;
    protected String cas_duracion;// duración en horas
    protected String cas_inicio;// inicio
    //    protected String cas_formato;
//    protected String cas_idioma;
    protected String cas_modalidad;
    protected String cas_fabricante;
    //    protected String cas_nivel;
//    protected String cas_oficial;
//    protected String cas_documentacion;
    protected String cas_descripcion;
    protected String cas_objetivos;
    //    protected String cas_audiencia;
    protected String cas_contenidos;
    protected String cas_image;
    //    protected String cas_pdf_curso;
    protected String cas_destacado;

    public cursodetallado() {
        super();
    }

    //    public cursodetallado(String v0, String v1, String v2, String v3, String v4, String v5, String v6
//            , String v7, String v8, String v9, String v10, String v11, String v12, String v13
//            , String v14, String v15, String v16, String v17, String v18, String v19, String v20) {
    public cursodetallado(String v0, String v1, String v2, String v3, String v4, String v5, String v6
            , String v9, String v10
            , String v14, String v15, String v17, String v18, String v20) {
        super();
        this.cas_area = v0;
        this.cas_categoria = v1;
        this.cas_subcategoria = v2;
        this.cas_sku = v3;
        this.cas_nombre = v4;
        this.cas_duracion = v5;
        this.cas_inicio = v6;
//        this.cas_formato = v7;
//        this.cas_idioma = v8;
        this.cas_modalidad = v9;
        this.cas_fabricante = v10;
//        this.cas_nivel = v11;
//        this.cas_oficial = v12;
//        this.cas_documentacion = v13;
        this.cas_descripcion = v14;
        this.cas_objetivos = v15;
//        this.cas_audiencia = v16;
        this.cas_contenidos = v17;
        this.cas_image = v18;
//        this.cas_pdf_curso = v19;
        this.cas_destacado = v20;
    }

    public String getArea() {
        return cas_area;
    }

    public void setArea(String area) {
        this.cas_area = area;
    }

    public String getCategoria() {
        return cas_categoria;
    }

    public void setCategoria(String categoria) {
        this.cas_categoria = categoria;
    }

    public String getSubcategoria() {
        return cas_subcategoria;
    }

    public void setSubcategoria(String subcategoria) { this.cas_subcategoria = subcategoria; }

    public String getSku() {
        return cas_sku;
    }

    public void setSku(String sku) {
        this.cas_sku = sku;
    }

    public String getNombre() {
        return cas_nombre;
    }

    public void setNombre(String nombre) {
        this.cas_nombre = nombre;
    }

    public String getDuracion() {
        return cas_duracion;
    }

    public void setDuracion(String duracion) {
        this.cas_duracion = duracion;
    }

    public String getInicio() {
        return cas_inicio;
    }

    public void setInicio(String inicio) {
        this.cas_inicio = inicio;
    }
    /*
        public String getFormato() {
            return cas_formato;
        }

        public void setFormato(String formato) {
            this.cas_formato = formato;
        }

        public String getIdioma() {
            return cas_idioma;
        }

        public void setIdioma(String idioma) {
            this.cas_idioma = idioma;
        }
    */
    public String getModalidad() {
        return cas_modalidad;
    }

    public void setModalidad(String modalidad) {
        this.cas_modalidad = modalidad;
    }

    public String getFabricante() { return cas_fabricante; }

    public void setFabricante(String fabricante) {
        this.cas_fabricante = fabricante;
    }
    /*
        public String getNivel() {
            return cas_nivel;
        }

        public void setNivel(String nivel) {
            this.cas_nivel = nivel;
        }

        public String getOficial() {
            return cas_oficial;
        }

        public void setOficial(String oficial) {
            this.cas_oficial = oficial;
        }

        public String getDocumentacion() {
            return cas_documentacion;
        }

        public void setDocumentacion(String documentacion) {
            this.cas_documentacion = documentacion;
        }
    */
    public String getDescripcion() {
        return cas_descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.cas_descripcion = descripcion;
    }

    public String getObjetivos() {
        return cas_objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.cas_objetivos = objetivos;
    }
    /*
        public String getAudiencia() {
            return cas_audiencia;
        }

        public void setAudiencia(String audiencia) {
            this.cas_audiencia = audiencia;
        }
    */
    public String getContenidos() {
        return cas_contenidos;
    }

    public void setContenidos(String contenidos) {
        this.cas_contenidos = contenidos;
    }

    public String getImage() {
        return cas_image;
    }

    public void setImage(String image ) {
        this.cas_image = image;
    }
    /*
            public String getPdf_curso() {
                return cas_pdf_curso;
            }

            public void setPdf_curso(String pdf_curso) {
                this.cas_pdf_curso = pdf_curso;
            }
        */
    public String getDestacado() {
        return cas_destacado;
    }

    public void setDestacado(String destacado) { this.cas_destacado = destacado; }

    public void putCursodetallado(cursodetallado cu) {
        this.cas_area = cu.getArea();
        this.cas_categoria = cu.getCategoria();
        this.cas_subcategoria = cu.getSubcategoria();
        this.cas_sku = cu.getSku();
        this.cas_nombre = cu.getNombre();
        this.cas_duracion = cu.getDuracion();
        this.cas_inicio = cu.getInicio();
//        this.cas_formato = cu.getFormato();
//        this.cas_idioma = cu.getIdioma();
        this.cas_modalidad = cu.getModalidad();
        this.cas_fabricante = cu.getFabricante();
//        this.cas_nivel = cu.getNivel();
//        this.cas_oficial = cu.getOficial();
//        this.cas_documentacion = cu.getDocumentacion();
        this.cas_descripcion = cu.getDescripcion();
        this.cas_objetivos = cu.getObjetivos();
//        this.cas_audiencia = cu.getAudiencia();
        this.cas_contenidos = cu.getContenidos();
        this.cas_image = cu.getImage();
//        this.cas_pdf_curso = cu.getPdf_curso();
        this.cas_destacado = cu.getDestacado();
    }
}
