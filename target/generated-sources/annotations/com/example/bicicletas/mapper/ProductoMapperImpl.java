package com.example.bicicletas.mapper;

import com.example.bicicletas.dto.ProductoDTO;
import com.example.bicicletas.entity.Producto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-05T14:01:18+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.18 (Microsoft)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoDTO productoToProductoDTO(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId_producto( producto.getId_producto() );
        productoDTO.setNombre( producto.getNombre() );
        productoDTO.setNum_serie( producto.getNum_serie() );
        productoDTO.setFab_com( producto.isFab_com() );
        productoDTO.setOferta( producto.isOferta() );
        productoDTO.setPrecio( producto.getPrecio() );
        productoDTO.setCoste_prod( producto.getCoste_prod() );
        productoDTO.setTamano( producto.getTamano() );
        productoDTO.setPeso( producto.getPeso() );
        productoDTO.setLinea( producto.getLinea() );
        productoDTO.setCalidad( producto.getCalidad() );
        productoDTO.setGenero( producto.getGenero() );
        productoDTO.setId_subcat( producto.getId_subcat() );

        return productoDTO;
    }

    @Override
    public Producto toEntityProducto(ProductoDTO productoDTO) {
        if ( productoDTO == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId_producto( productoDTO.getId_producto() );
        producto.setNombre( productoDTO.getNombre() );
        producto.setNum_serie( productoDTO.getNum_serie() );
        producto.setFab_com( productoDTO.isFab_com() );
        producto.setOferta( productoDTO.isOferta() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setCoste_prod( productoDTO.getCoste_prod() );
        producto.setTamano( productoDTO.getTamano() );
        producto.setPeso( productoDTO.getPeso() );
        producto.setLinea( productoDTO.getLinea() );
        producto.setCalidad( productoDTO.getCalidad() );
        producto.setGenero( productoDTO.getGenero() );
        producto.setId_subcat( productoDTO.getId_subcat() );

        return producto;
    }
}
