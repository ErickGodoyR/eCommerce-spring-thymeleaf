package com.tienda.botilleria.tienda.botilleria.controller;

import com.tienda.botilleria.tienda.botilleria.entity.DetalleOrdenCompra;
import com.tienda.botilleria.tienda.botilleria.entity.Orden;
import com.tienda.botilleria.tienda.botilleria.entity.Producto;
import com.tienda.botilleria.tienda.botilleria.repository.ProductoRepository;
import com.tienda.botilleria.tienda.botilleria.service.AlmacenServicioImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller("")
@RequestMapping("/")
public class HomeController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private AlmacenServicioImpl servicio;

    // para almacenar los detalles de la orden
    List<DetalleOrdenCompra> detalles = new ArrayList<DetalleOrdenCompra>();

    //datos de la orden
    Orden orden = new Orden();


    @GetMapping("")
    public ModelAndView paginaInicio(){
        List<Producto> todosLosProductos = productoRepository.findAll(PageRequest.of(0,4, Sort.by("nombre").descending())).toList();
        return  new ModelAndView("index")
                .addObject("todosLosProductos",todosLosProductos);
    }

    //mostrar todos los productos
    @GetMapping("/productos")
    public ModelAndView listarProductos(@PageableDefault(sort = "nombre") Pageable pageable){
        Page<Producto> productos = productoRepository.findAll(pageable);
        return new ModelAndView("productos")
                .addObject("productos", productos);
    }


    //agregar producto al carro de compras
    @PostMapping("/cart")
    public String agregarCarro(@RequestParam(required = false) Integer id,
                               @RequestParam(required = false) Integer cantidad, Model model){
        DetalleOrdenCompra detalleOrdenCompra = new DetalleOrdenCompra();
        Producto producto = new Producto();
        double sumaTotal = 0;

        Optional<Producto> optionalProducto = servicio.get(id);
        log.info("Producto añadido: {}", optionalProducto.get());
        log.info("Cantidad: {}", cantidad);

        producto = optionalProducto.get();

        detalleOrdenCompra.setCantidad(cantidad);
        detalleOrdenCompra.setRutaImagen(producto.getRutaImagen());
        detalleOrdenCompra.setPrecio(producto.getPrecio());
        detalleOrdenCompra.setNombre(producto.getNombre());
        detalleOrdenCompra.setTotal(producto.getPrecio() * cantidad);
        detalleOrdenCompra.setProducto(producto);

        detalles.add(detalleOrdenCompra);

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "productos/carro_compras";
    }


    //Mostrar carro de compras
    @GetMapping("/getCart")
    public String obtenerCart(Model model) {

        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "/productos/carro_compras";
    }

}
