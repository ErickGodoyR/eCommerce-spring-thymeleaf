package com.tienda.botilleria.tienda.botilleria.service;

import com.tienda.botilleria.tienda.botilleria.DTO.UsuarioRegistroDTO;
import com.tienda.botilleria.tienda.botilleria.entity.Rol;
import com.tienda.botilleria.tienda.botilleria.entity.Usuario;
import com.tienda.botilleria.tienda.botilleria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    public UsuarioRepository usuarioRepository;


    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
       Usuario usuario = new Usuario(registroDTO.getId(), registroDTO.getNombre(), registroDTO.getApellido_paterno(),
               registroDTO.getApellido_materno(), registroDTO.getDireccion(), registroDTO.getCiudad(),
               registroDTO.getEmail(), registroDTO.getPassword(), Arrays.asList(new Rol("USER")));

       return usuarioRepository.save(usuario);
    }


}
