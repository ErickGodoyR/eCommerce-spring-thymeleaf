package com.tienda.botilleria.tienda.botilleria.service;

import com.tienda.botilleria.tienda.botilleria.DTO.UsuarioRegistroDTO;
import com.tienda.botilleria.tienda.botilleria.entity.Usuario;

public interface UsuarioServicio {

    //List<Usuario> findAll();
    //Optional<Usuario> findById(Long id);
    //Usuario save (Usuario usuario);
    //Optional<Usuario> findByEmail(String email);

    public Usuario guardar(UsuarioRegistroDTO registroDTO);

}
