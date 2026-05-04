package com.example.bicicletas.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bicicletas.dto.ProductoDTO;
import com.example.bicicletas.service.ProductoService;

@Controller
public class ProductoViewController {

    private final ProductoService productoService;

    public ProductoViewController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public String listarProductos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Page<ProductoDTO> paginaProductos = productoService.getAllProductos(PageRequest.of(page, size));
        model.addAttribute("productos", paginaProductos.getContent());
        model.addAttribute("paginaActual", page);
        model.addAttribute("totalPaginas", paginaProductos.getTotalPages());
        model.addAttribute("totalElementos", paginaProductos.getTotalElements());
        return "productos";
    }
}
