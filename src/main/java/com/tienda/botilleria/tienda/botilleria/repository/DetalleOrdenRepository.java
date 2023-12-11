package com.tienda.botilleria.tienda.botilleria.repository;

import com.tienda.botilleria.tienda.botilleria.entity.DetalleOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrdenCompra, Integer> {
}
