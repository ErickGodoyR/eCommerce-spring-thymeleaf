package com.tienda.botilleria.tienda.botilleria.controller;

import com.tienda.botilleria.tienda.botilleria.entity.Producto;
import com.tienda.botilleria.tienda.botilleria.repository.CategoriaRepository;
import com.tienda.botilleria.tienda.botilleria.repository.ProductoRepository;
import com.tienda.botilleria.tienda.botilleria.service.AlmacenServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductoController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private AlmacenServicioImpl servicio;


    @GetMapping("")
    public ModelAndView verTotalProductos(@PageableDefault(sort = "id",size = 12) Pageable pageable){
        Page<Producto> total_productos = productoRepository.findAll(pageable);
        return new ModelAndView("productos/productos")
                .addObject("productos",total_productos);
    }

    @GetMapping("/cervezas")
    public ModelAndView verTotalCervezas(){
        List<Producto> productos_cerveza = servicio.findAllCervezas();
        return new ModelAndView("productos/cerveza")
                .addObject("prod_cerveza",productos_cerveza);
    }

    @GetMapping("/bebidas")
    public ModelAndView verTotalBebidas(){
        List<Producto> productos_bebida = servicio.findAllBebidas();
        return new ModelAndView("productos/bebida")
                .addObject("prod_bebida",productos_bebida);
    }

    @GetMapping("/vinos")
    public ModelAndView verTotalVinos(){
        List<Producto> productos_vinos = servicio.findAllVinos();
        return new ModelAndView("productos/vino")
                .addObject("vinos", productos_vinos);
    }

    @GetMapping("/licores")
    public ModelAndView verTotalLicores(){
        List<Producto> productos_licores = servicio.findAllLicores();
        return new ModelAndView("productos/licores")
                .addObject("licores",productos_licores);
    }

}
