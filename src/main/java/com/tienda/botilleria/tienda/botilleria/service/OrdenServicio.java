package com.tienda.botilleria.tienda.botilleria.service;

import com.tienda.botilleria.tienda.botilleria.entity.Orden;

import java.util.List;
import java.util.Optional;

public interface OrdenServicio {

    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save (Orden orden);
    String generarNumeroOrden();
}
