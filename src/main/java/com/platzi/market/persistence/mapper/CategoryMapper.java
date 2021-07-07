package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({

            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    /*
    * Con esta anotación aplicamos el mismo mapeo del método anterior
    * pero en sentido contrario
    * */
    @InheritInverseConfiguration
    /*Como en la clase "Categoria" hay un atributo que se llama "productos"
    * que no existe en la clase "Category" debemos excluirlo del mapeo usando ignore = true
    * en la anotación Mapping
    * */
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
