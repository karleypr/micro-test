package com.test.micro.ports.input;

import com.test.micro.domain.model.Fields;
import com.test.micro.domain.model.Price;

import java.time.Instant;
import java.util.List;

/**
 * La interfaz GetPriceUseCase declara el método para obtener el precio de un producto
 */
public interface GetPriceUseCase {

    /**
     * Este método obtiene los detalles del precio de un producto
     *
     * @param productId El identificador del producto
     * @param brandId El identificador de la marca
     * @param applicationDate La fecha de aplicación
     * @return Price El modelo con los detalles del precio
     */
    Price getPriceBy(Integer productId, Integer brandId, Instant applicationDate);

    /**
     * Este método obtiene los detalles del precio de un producto mediante filtros
     *
     * @param fields filtros para realizar la consulta
     * @return List<Price> Lista de el modelo con los detalles del precio
     */
    List<Price> getpriceByFilters(Fields fields );
}
