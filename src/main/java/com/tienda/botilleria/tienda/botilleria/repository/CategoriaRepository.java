package com.tienda.botilleria.tienda.botilleria.repository;

import com.tienda.botilleria.tienda.botilleria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
