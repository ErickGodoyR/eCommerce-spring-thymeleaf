package com.tienda.botilleria.tienda.botilleria.controller;

import com.tienda.botilleria.tienda.botilleria.DTO.UsuarioRegistroDTO;
import com.tienda.botilleria.tienda.botilleria.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    public UsuarioServicio usuarioServicio;

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO nuevoUsuarioDTO(){
        return new UsuarioRegistroDTO();
    }


    @GetMapping("/nvoUsuario")
    public String registrarUsuario() {

        return "usuarios/agregarUsuario";
    }

    @GetMapping("/login")
    public String iniciarSesion() {

        return "usuarios/login";
    }

    //agrega un nuevo usuario y redirecciona a la página de agregar usuario
    @PostMapping("/agregarUsuario")
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO usuarioDTO){
        usuarioServicio.guardar(usuarioDTO);
        return "redirect:/usuarios/nvoUsuario?exito";
    }


}
