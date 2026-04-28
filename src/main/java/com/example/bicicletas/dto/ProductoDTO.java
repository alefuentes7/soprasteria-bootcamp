package com.example.bicicletas.dto;

import java.math.BigDecimal;

//crear la clase ProductoDTO + realizar mapeo Producto - ProductoDTO con MapStruct + devolver Producto DTO en la capa de controller

public class ProductoDTO {

    private Integer id_producto;
    private String nombre;
    private String num_serie;
    private boolean fab_com;
    private boolean oferta;
    private BigDecimal precio;
    private BigDecimal coste_prod;
    private String tamano;
    private BigDecimal peso;
    private Integer linea;
    private Integer calidad;
    private Integer genero;
    private Integer id_subcat;

    public ProductoDTO() {
        //Constructor vacio
    }

    //getters y setters
    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public boolean isFab_com() {
        return fab_com;
    }

    public void setFab_com(boolean fab_com) {
        this.fab_com = fab_com;
    }

    public boolean isOferta() {
        return oferta;
    }

    public void setOferta(boolean oferta) {
        this.oferta = oferta;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getCoste_prod() {
        return coste_prod;
    }

    public void setCoste_prod(BigDecimal coste_prod) {
        this.coste_prod = coste_prod;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public Integer getCalidad() {
        return calidad;
    }

    public void setCalidad(Integer calidad) {
        this.calidad = calidad;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public Integer getId_subcat() {
        return id_subcat;
    }

    public void setId_subcat(Integer id_subcat) {
        this.id_subcat = id_subcat;
    }

    @Override
    public String toString() {
        return "ProductoDTO [id_producto=" + id_producto + ", nombre=" + nombre + ", num_serie=" + num_serie
                + ", fab_com=" + fab_com + ", oferta=" + oferta + ", precio=" + precio + ", coste_prod=" + coste_prod
                + ", tamano=" + tamano + ", peso=" + peso + ", linea=" + linea + ", calidad=" + calidad + ", genero="
                + genero + ", id_subcat=" + id_subcat + "]";
    }

    
    


    

}
