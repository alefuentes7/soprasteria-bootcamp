package com.example.bicicletas.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bicicletas.dto.ProductoDTO;
import com.example.bicicletas.entity.Producto;
import com.example.bicicletas.mapper.ProductoMapper;
import com.example.bicicletas.repository.ProductoRepository;

//import jakarta.transaction.Transactional;

import java.util.Optional;

//hacer todo con DTOs


@Service
public class ProductoService {
    
    @Autowired
    private final ProductoRepository productoRepository;

    @Autowired
    private final ProductoMapper productoMapper;

    //@SuppressWarnings("null")
    public Page<ProductoDTO> getAllProductos(Pageable pageable) {
        return productoRepository.findAll(pageable).map(productoMapper::productoToProductoDTO);
    }

    public ProductoService(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    public List<ProductoDTO> getAllProductos() {
        return productoRepository.findAll().stream()
        .map(productoMapper::productoToProductoDTO) 
        .toList();
    }

    public List<ProductoDTO> readAll() {  //para leer todo
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(productoMapper::productoToProductoDTO)
                .toList();

    }

        //para mapear ida y vuelta
    public ProductoDTO mapRoundTrip(ProductoDTO dto) {
        Producto entity = productoMapper.toEntityProducto(dto);
        return productoMapper.productoToProductoDTO(entity);
    
    }


    public Optional<ProductoDTO> readProductoById(int id) { //para leer por id
        return productoRepository.findById(id).map(productoMapper::productoToProductoDTO);
    }


    //@Transactional esto no se si es obligatorio, no hace falta
    //@SuppressWarnings("null") esto se pone??
    public ProductoDTO createProducto (ProductoDTO productoDTO) { //para crear
        Producto producto = productoMapper.toEntityProducto(productoDTO);
        Producto savedProducto = productoRepository.save(producto);
        return productoMapper.productoToProductoDTO(savedProducto);
        
    }

        //update, pero no de producto entero
    public Optional<ProductoDTO> updatePrecio(int id, BigDecimal precio1) {
        if (precio1 == null || precio1.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser ni null ni negativo");
        }
        return productoRepository.findById(id).map(p -> {
            p.setPrecio(precio1);
            Producto actualizado = productoRepository.save(p);
            return productoMapper.productoToProductoDTO(actualizado);
        });
    }

        //también se puede hacer update de un producto previamente modificado
        public Optional<ProductoDTO> updateProducto(int id, ProductoDTO productoDTO) {
            if (productoRepository.existsById(id)) {
                Producto producto = productoMapper.toEntityProducto(productoDTO);
                producto.setId_producto(id);
                Producto updatedProducto = productoRepository.save(producto);
                return Optional.of(productoMapper.productoToProductoDTO(updatedProducto));
            }
            return Optional.empty();
        }

        public boolean deleteProducto(int id) {
            if (productoRepository.existsById(id)) {
                productoRepository.deleteById(id);
                return true;
            }
            return false;
        }

    }



