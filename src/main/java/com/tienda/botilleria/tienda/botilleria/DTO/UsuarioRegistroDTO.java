package com.tienda.botilleria.tienda.botilleria.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRegistroDTO {

    private Long id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String direccion;
    private String ciudad;
    private String email;
    private String password;

}
