package com.tienda.botilleria.tienda.botilleria.controller;

import com.tienda.botilleria.tienda.botilleria.entity.Categoria;
import com.tienda.botilleria.tienda.botilleria.entity.Producto;
import com.tienda.botilleria.tienda.botilleria.repository.CategoriaRepository;
import com.tienda.botilleria.tienda.botilleria.repository.ProductoRepository;
import com.tienda.botilleria.tienda.botilleria.service.AlmacenServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private AlmacenServicioImpl servicio;


    @GetMapping("")
    public ModelAndView verIndex(@PageableDefault(sort = "id",size = 5) Pageable pageable){
        Page<Producto> productos = productoRepository.findAll(pageable);
        return new ModelAndView("admin/index").addObject("productos",productos);
    }

    @GetMapping("/productos/nuevo")
    public ModelAndView formularioAgregarProducto(){
        List<Categoria> categorias = categoriaRepository.findAll(Sort.by("id"));
        return new ModelAndView("admin/nuevo_producto")
                .addObject("producto", new Producto())
                .addObject("categorias",categorias);

    }


    @PostMapping("/productos/nuevo")
    public ModelAndView agregarProducto(@Validated Producto producto, BindingResult bindingResult){
        if(bindingResult.hasErrors() || producto.getPortada().isEmpty()){
            if(producto.getPortada().isEmpty()){
                bindingResult.rejectValue("portada","MultipartNotEmpty");
            }

            List<Categoria> categorias = categoriaRepository.findAll();

            return new ModelAndView("admin/nuevo_producto")
                    .addObject("producto",producto)
                    .addObject("categorias",categorias);
        }


        String rutaImagen = servicio.almacenarArchivo(producto.getPortada());
        producto.setRutaImagen(rutaImagen);

        productoRepository.save(producto);
        return new ModelAndView("redirect:/admin");

    }

    //Eliminar producto
    @PostMapping("/productos/{id}/eliminar")
    public String eliminarProducto(@PathVariable Integer id){
        Producto producto = productoRepository.getOne(id);
        productoRepository.delete(producto);

        servicio.eliminarArchivo(producto.getRutaImagen());

        return "redirect:/admin";
    }


    @GetMapping("/productos/{id}/editar")
    public ModelAndView obtenerProductoEditar(@PathVariable Integer id){
        Producto producto = productoRepository.getOne(id);
        List<Categoria> categorias = categoriaRepository.findAll();

        return new ModelAndView("admin/editar_producto")
                .addObject("producto", producto)
                .addObject("categorias", categorias);
    }


    @PostMapping("/productos/{id}/editar")
    public ModelAndView actualizarProducto(@PathVariable Integer id, @Validated Producto producto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<Categoria> categorias = categoriaRepository.findAll();
            return new ModelAndView("admin/editar_producto")
                    .addObject("producto", producto)
                    .addObject("categorias", categorias);
        }

        Producto productoDB = productoRepository.getOne(id);

        productoDB.setNombre(producto.getNombre());
        productoDB.setStock(producto.getStock());
        productoDB.setPrecio(producto.getPrecio());
        productoDB.setCategoria(producto.getCategoria());

        if(!producto.getPortada().isEmpty()){
            servicio.eliminarArchivo(productoDB.getRutaImagen());
            String rutaImagen = servicio.almacenarArchivo(producto.getPortada());
            productoDB.setRutaImagen(rutaImagen);
        }

        productoRepository.save(productoDB);
        return new ModelAndView("redirect:/admin");

    }


}





