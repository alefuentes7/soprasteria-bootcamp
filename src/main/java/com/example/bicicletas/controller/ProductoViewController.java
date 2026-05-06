package com.example.bicicletas.controller;

import com.example.bicicletas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bicicletas.dto.ProductoDTO;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoViewController {

    @Autowired
    private ProductoService productoService;

    // Lista de productos
    @GetMapping()
    public String mostrarProductos(
            @PageableDefault(size = 10) Pageable pageable,
            Model model) {

        Page<ProductoDTO> page = productoService.getAllProductos(pageable);

        model.addAttribute("productos", page.getContent());
        model.addAttribute("totalElementos", page.getTotalElements());
        model.addAttribute("totalPaginas", page.getTotalPages());
        model.addAttribute("paginaActual", page.getNumber());

        model.addAttribute("view", "productos");

        return "layout";
    }


    // DÉTAIL
    @GetMapping("/{id}")
    public String detalleProducto(@PathVariable Integer id, Model model) {

        Optional<ProductoDTO> productoOpt = productoService.readProductoById(id);

        if (productoOpt.isEmpty()) {
            return "redirect:/productos"; // ou page 404
        }

        model.addAttribute("producto", productoOpt.get());
        model.addAttribute("view", "producto-detalle");

        return "layout";
    }

    @GetMapping("/new")
    public String nuevo(Model model) {
        model.addAttribute("view", "anadir-producto");

        return "layout";
    }

    // Anadir Producto
    @PostMapping("/create")
    public String createProducto(
            @RequestParam String nombre,
            @RequestParam(required = false) String num_serie,
            @RequestParam(required = false) boolean fab_com,
            @RequestParam(required = false) boolean oferta,
            @RequestParam BigDecimal precio,
            @RequestParam(required = false) BigDecimal coste_prod,
            @RequestParam(required = false) String tamano,
            @RequestParam(required = false) BigDecimal peso,
            @RequestParam(required = false) Integer linea,
            @RequestParam(required = false) Integer calidad,
            @RequestParam(required = false) Integer genero,
            @RequestParam(required = false) Integer id_subcat,
            @RequestParam(required = false) String imagenUrl
    ) {

        ProductoDTO dto = new ProductoDTO();

        dto.setNombre(nombre);
        dto.setNum_serie(num_serie);
        dto.setFab_com(fab_com);
        dto.setOferta(oferta);
        dto.setPrecio(precio);
        dto.setCoste_prod(coste_prod);
        dto.setTamano(tamano);
        dto.setPeso(peso);
        dto.setLinea(linea);
        dto.setCalidad(calidad);
        dto.setGenero(genero);
        dto.setId_subcat(id_subcat);
        dto.setImagenUrl(imagenUrl);

        productoService.createProducto(dto);

        return "redirect:/productos";
    }

}

