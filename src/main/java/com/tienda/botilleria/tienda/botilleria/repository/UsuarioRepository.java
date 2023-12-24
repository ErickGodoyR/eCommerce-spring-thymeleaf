package com.tienda.botilleria.tienda.botilleria.repository;

import com.tienda.botilleria.tienda.botilleria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

}
