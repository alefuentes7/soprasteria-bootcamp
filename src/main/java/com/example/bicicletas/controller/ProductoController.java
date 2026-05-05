package com.example.bicicletas.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bicicletas.dto.ProductoDTO;
import com.example.bicicletas.service.ProductoService;

//import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<Page<ProductoDTO>> getAllProductos( //en la ? devuelve una lista de productos, no uno solo. El tipo entre <> refleja una colección
            @PageableDefault(size=10) Pageable pageable) {
                return ResponseEntity.ok(productoService.getAllProductos(pageable));
            }

    @GetMapping("/producto/{id}")
    public ResponseEntity<ProductoDTO> getByProductoById(@PathVariable int id) {
        return productoService.readProductoById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/producto")
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.createProducto(productoDTO);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable int id, @RequestBody ProductoDTO productoDTO) {
        return productoService.updateProducto(id, productoDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable int id) {
        if (productoService.deleteProducto(id)) {
            return ResponseEntity.ok("Borrado producto con ID: " + id);
        }
        return ResponseEntity.status(404).body("Producto no encontrado");
    }

}
