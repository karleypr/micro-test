package com.test.micro.ports.output;

import com.test.micro.domain.model.Fields;
import com.test.micro.domain.model.Price;

import java.time.Instant;
import java.util.List;

/**
 * La interfaz de puerto de salida PricesPersistenceOutputPort declara el método
 * para obtener los precios de un producto
 */
public interface PricesPersistenceOutputPort {

    /**
     * Este método obtiene un listado de los detalles del precio de un producto
     *
     * @param productId El identificador del producto
     * @param brandId El identificador de la marca
     * @param applicationDate La fecha de aplicación
     * @return List<Price> El listado del modelo con los detalles del precio
     */
    List<Price> getPriceBy(Integer productId, Integer brandId, Instant applicationDate);

    /**
     * Este método obtiene los detalles del precio de un producto mediante filtros
     *
     * @param fields filtros para realizar la consulta
     * @return List<Price> El listado del modelo con los detalles del precio
     */
    List<Price> getpriceByFilters(Fields fields);

}
