package com.tienda.botilleria.tienda.botilleria.service;

import com.tienda.botilleria.tienda.botilleria.entity.DetalleOrdenCompra;
import com.tienda.botilleria.tienda.botilleria.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DetalleOrdenServicioImpl implements DetalleOrdenServicio{

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public DetalleOrdenCompra save(DetalleOrdenCompra detalleOrdenCompra) {
        return detalleOrdenRepository.save(detalleOrdenCompra);
    }
}
