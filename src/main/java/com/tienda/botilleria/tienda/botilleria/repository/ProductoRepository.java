package com.tienda.botilleria.tienda.botilleria.repository;

import com.tienda.botilleria.tienda.botilleria.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //Mostrar cervezas
    @Query(value ="select * from producto where id_categoria='2'", nativeQuery = true)
    List<Producto> findAllCervezas();

    //Mostrar bebidas
    @Query(value= "select * from producto where id_categoria='1'", nativeQuery = true)
    List<Producto> findAllBebidas();

    //Mostrar vinos
    @Query(value= "select * from producto where id_categoria='4'", nativeQuery = true)
    List<Producto> findAllVinos();

    //Mostrar licores
    @Query(value= "select * from producto where id_categoria='3'", nativeQuery = true)
    List<Producto> findAllLicores();

}
