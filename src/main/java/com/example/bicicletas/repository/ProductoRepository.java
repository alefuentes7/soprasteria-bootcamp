package com.example.bicicletas.repository;

import org.springframework.stereotype.Repository;

import com.example.bicicletas.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//BBDD 

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //public Producto findAll(); //con findAll() me sirve de momento, no nercesitop escribirlo, lo heredo del jparepository
    // si lo quisierav poner:
    //List<Producto> findAll();

    @Query("SELECT DISTINCT p FROM Producto p LEFT JOIN FETCH p.analisis")
    List<Producto>findAllWithAnalisis();

    /*public void createObject() {
        Producto prod = new Producto("","");*/ //esto lo hizo enrique
    }
    

