package com.tienda.botilleria.tienda.botilleria.service;

import com.tienda.botilleria.tienda.botilleria.entity.Producto;
import com.tienda.botilleria.tienda.botilleria.excepciones.AlmacenExcepcion;
import com.tienda.botilleria.tienda.botilleria.excepciones.FileNotFoundException;
import com.tienda.botilleria.tienda.botilleria.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class AlmacenServicioImpl implements AlmacenServicio{

    @Autowired
    ProductoRepository productoRepository;

    @Value("${storage.location}")
    private String storageLocation;

    @Override
    public Optional<Producto> get(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    @PostConstruct
    public void iniciarAlmacenDeArchivos() {
        try{
            Files.createDirectories(Paths.get(storageLocation));
        }catch(Exception e){
            System.out.println(e);
        }

    }

    @Override
    public String almacenarArchivo(MultipartFile archivo) {
        String nombreArchivo = archivo.getOriginalFilename();
        if(archivo.isEmpty()){
            throw new AlmacenExcepcion("No se puede almacenar archivo vacío");
        }
        try{
            InputStream inputStream = archivo.getInputStream();
            Files.copy(inputStream,Paths.get(storageLocation).resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException excepcion){
            throw new AlmacenExcepcion("Error al almacenar archivo " + nombreArchivo,excepcion);
        }
        return nombreArchivo;
    }

    @Override
    public Path cargarArchivo(String nombreArchivo) {
        return Paths.get(storageLocation).resolve(nombreArchivo);
    }

    @Override
    public Resource cargarConRecurso(String nombreArchivo) {
        try{
            Path archivo = cargarArchivo(nombreArchivo);
            Resource recurso = new UrlResource(archivo.toUri());

            if(recurso.exists() || recurso.isReadable()){
                return recurso;
            }else{
                throw new FileNotFoundException("No se pudo encontrar el archivo " + nombreArchivo);
            }

        }catch(MalformedURLException excepcion){
            throw new FileNotFoundException("Archivo no encoontrado " + nombreArchivo,excepcion);
        }

    }

    @Override
    public void eliminarArchivo(String nombreArchivo) {
        Path archivo = cargarArchivo(nombreArchivo);

        try{
            FileSystemUtils.deleteRecursively(archivo);
        }catch(Exception excepcion){
            System.out.println(excepcion);
        }

    }

    @Override
    public List<Producto> findAllCervezas() {
        return productoRepository.findAllCervezas();
    }

    @Override
    public List<Producto> findAllBebidas() {
        return productoRepository.findAllBebidas();
    }

    @Override
    public List<Producto> findAllVinos() {
        return productoRepository.findAllVinos();
    }

    @Override
    public List<Producto> findAllLicores() {
        return productoRepository.findAllLicores();
    }


}
