package com.example.bicicletas.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;



@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id_producto;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private java.util.List<Formulario> analisis; //cambiar y poner el mismo nombre en formulario y analisis

    @Column(name = "nombre", nullable=false, length=150)
    private String nombre;
    @Column(name = "num_serie", nullable=false, length=50, unique=true)
    private String num_serie;
    @Column(name = "fab_com", nullable=false)
    private boolean fab_com;
    @Column(name = "oferta", nullable=false)
    private boolean oferta;
    @Column(name = "precio", nullable=false, precision = 5, scale=2)
    private BigDecimal precio;
    @Column(name = "coste_prod", nullable=false, precision = 5, scale=2)
    private BigDecimal coste_prod;
    @Column(name = "tamano",nullable=true, length=50)
    private String tamano;
    @Column(name = "peso", nullable=true, precision = 6, scale=2)
    private BigDecimal peso;
    @Column(name = "linea", nullable=false)
    private Integer linea;
    @Column(name = "calidad", nullable=true)
    private Integer calidad;
    @Column(name = "genero")
    private Integer genero;
    @Column(name = "id_subcat")
    private Integer id_subcat;
    

    public Producto() {
        //Constructor vacio
    }
    

    //Getters y Setters
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
        return id_producto + " | " + nombre + " | " + num_serie + " | " + precio;

    }

}

