package com.test.micro.adapters.output.persistence.repository;

import com.test.micro.adapters.output.persistence.entity.PriceEntity;
import com.test.micro.domain.model.Fields;

import java.util.List;

public interface PricesRepositoryCustom {

    /**
     * Este método obtiene los detalles del precio de un producto mediante filtros
     *
     * @param fields filtros para realizar la consulta
     * @return List<Price> El listado del modelo con los detalles del precio
     */
    List<PriceEntity> getPrinceByFilters (Fields fields);
}
