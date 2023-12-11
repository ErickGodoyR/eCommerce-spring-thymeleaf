package com.tienda.botilleria.tienda.botilleria.repository;

import com.tienda.botilleria.tienda.botilleria.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
}
