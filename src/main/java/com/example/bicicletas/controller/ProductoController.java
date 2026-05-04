package com.example.bicicletas.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bicicletas.dto.ProductoDTO;
import com.example.bicicletas.service.ProductoService;

//import java.math.BigDecimal;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/api/productos")
    public ResponseEntity<Page<ProductoDTO>> getAllProductos( //en la ? devuelve una lista de productos, no uno solo. El tipo entre <> refleja una colección
            @PageableDefault(size=10) Pageable pageable) {
                return ResponseEntity.ok(productoService.getAllProductos(pageable));
            }
    //luego hay que probar a hacerlo paginable (Pageable pageable) y retornar la lista paginada*/

    @GetMapping("/api/producto/{id}")
    public ResponseEntity<ProductoDTO> getByProductoById(@PathVariable int id) {
        return productoService.readProductoById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/producto")
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.createProducto(productoDTO);
    }

    @PutMapping("/api/producto/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable int id, @RequestBody ProductoDTO productoDTO) {
        return productoService.updateProducto(id, productoDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/api/producto/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable int id) {
        if (productoService.deleteProducto(id)) {
            return ResponseEntity.ok("Borrado producto con ID: " + id);
        }
        return ResponseEntity.status(404).body("Producto no encontrado");
    }

}
