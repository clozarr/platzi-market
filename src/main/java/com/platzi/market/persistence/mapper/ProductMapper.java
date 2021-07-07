package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/*
* Dado que estamos mapeando el atributo "categoria" de la clase Producto, hacia el atributo "category" del
* de la clase Product, pero Category ya tiene su mapper, entonces le indicamos a la interfaz ProductMaper mediante
* la anotación "Mapper" que use el Mapeo de CategoryMapper
* */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {


    @Mappings({

            @Mapping(source ="idProducto" ,target ="productId" ),
            @Mapping(source ="nombre" ,target ="name" ),
            @Mapping(source ="idCategoria" ,target ="categoryId" ),
            @Mapping(source ="precioVenta" ,target ="price" ),
            @Mapping(source ="cantidadStock" ,target ="stock" ),
            @Mapping(source ="estado" ,target ="active" ),
            @Mapping(source ="categoria" ,target ="category" ),

    })
    Product toProduct(Producto producto);
     /*
     * Hereda el mapeo del método anterior porque es del mismo tipo
     * */
    List<Product> toProducts(List<Producto> productos);


    /*
    * Heredamos el mapero del método anterior, pero a la inversa
    * */
    @InheritInverseConfiguration
    /*
    * Como el atributo código de barras no existe en la clase "Product" lo excluimos del mapeo
    * */
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);

}
