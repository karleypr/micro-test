package com.test.micro.domain.service;

import com.test.micro.domain.model.Fields;
import com.test.micro.domain.model.Price;
import com.test.micro.ports.input.GetPriceUseCase;
import com.test.micro.ports.output.PricesPersistenceOutputPort;
import com.test.micro.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * Implementación de la interfaz GetPriceUseCase
 */
@Service
@AllArgsConstructor
public class PriceService implements GetPriceUseCase {

    /**
     * Inyección del servicio PricesPersistenceOutputPort
     */
    private PricesPersistenceOutputPort pricesPersistenceOutputPort;

    /**
     * Este método obtiene los detalles del precio de un producto
     *
     * @param productId El identificador del producto
     * @param brandId El identificador de la marca
     * @param applicationDate La fecha de aplicación
     * @return Price El modelo con los detalles del precio
     */
    @Override
    public Price getPriceBy(Integer productId, Integer brandId, Instant applicationDate) {

        List<Price> priceList = pricesPersistenceOutputPort.getPriceBy(productId, brandId,
                applicationDate);

        if (priceList.size() >= Constants.PRICE_LIST_SIZE){
            return priceList.stream().filter(Price::getPriority).findFirst().orElseThrow();
        }

        return priceList.stream().findFirst().orElseThrow();
    }

    /**
     * Este método obtiene los detalles del precio de un producto mediante filtros
     *
     * @param fields filtros para realizar la consulta
     * @return List<Price> Lista de el modelo con los detalles del precio
     */
    @Override
    public List<Price> getpriceByFilters(Fields fields) {
        return pricesPersistenceOutputPort.getpriceByFilters(fields);
    }

}
