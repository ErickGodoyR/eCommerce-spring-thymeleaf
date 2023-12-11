package com.tienda.botilleria.tienda.botilleria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "detalles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;
    private String rutaImagen;


    @ManyToOne
    private Orden orden;

    @ManyToOne
    private Producto producto;


    @Transient
    private MultipartFile portada;
}
