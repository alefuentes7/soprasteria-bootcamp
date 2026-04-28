package com.example.bicicletas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.bicicletas.dto.ProductoDTO;
import com.example.bicicletas.entity.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);
    ProductoDTO productoToProductoDTO(Producto producto);
    Producto toEntityProducto(ProductoDTO productoDTO);


}


