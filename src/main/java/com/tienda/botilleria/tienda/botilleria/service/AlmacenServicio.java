package com.tienda.botilleria.tienda.botilleria.service;


import com.tienda.botilleria.tienda.botilleria.entity.Producto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface AlmacenServicio {

    public Optional<Producto> get(Integer id);

    public void iniciarAlmacenDeArchivos();

    public String almacenarArchivo(MultipartFile archivo);

    public Path cargarArchivo(String nombreArchivo);

    public Resource cargarConRecurso(String nombreArchivo);

    public void eliminarArchivo(String nombreArchivo);


    public List<Producto> findAllCervezas();

    public List<Producto> findAllBebidas();

    public List<Producto> findAllVinos();

    public List<Producto> findAllLicores();
}
