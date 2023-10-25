package com.test.micro.adapters.output.persistence.mapper;

import com.test.micro.adapters.output.persistence.entity.PriceEntity;
import com.test.micro.domain.model.Price;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Esta clase representa un mapper entre Modelo y Entidad
 */
@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    /**
     * To Domain From Entity
     *
     * @param pricesEntity La entidad
     * @return List<Price> Listado del modelo con la respuesta del mapper
     */
    List<Price> toDomainFromEntity(List<PriceEntity> pricesEntity);
}
