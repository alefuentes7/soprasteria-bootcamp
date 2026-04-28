package com.example.bicicletas.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//revisar cuando haga el servicio web de Listado de productos

@Entity
@Table(name="formulario")
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_analisis")
    private Integer id_analisis;

    //aqui hay que hacer la FK de formulario.id_producto -> producto.id_producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_producto", nullable=false)
    private Producto producto;

    @Column(name="fecha", nullable=false)
    private LocalDate fecha;  
    @Column(name="nombre_creador", nullable=false, length=100)
    private String nombre_creador;
    @Column(name="correo", nullable=false, length=150)
    private String correo;
    @Column(name="valoracion", nullable=false)  
    private boolean valoracion;
    @Column(name="comentario", columnDefinition = "TEXT")
    private String comentario;

    public Formulario() {
        //Constructor vacio
    }


    //Getters/Setters
    public Integer getId_analisis() {
        return id_analisis;
    }

    public void setId_analisis(Integer id_analisis) {
        this.id_analisis = id_analisis;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre_creador() {
        return nombre_creador;
    }

    public void setNombre_creador(String nombre_creador) {
        this.nombre_creador = nombre_creador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isValoracion() {
        return valoracion;
    }

    public void setValoracion(boolean valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Analisis#" + id_analisis +
        " (" + fecha + ") " +
        nombre_creador + " - " + 
        valoracion + "/5 : " +
        (comentario != null ? comentario : "");
    

    }  
   

}

