package com.test.micro.adapters.output.persistence;

import com.test.micro.adapters.output.persistence.mapper.PriceEntityMapper;
import com.test.micro.adapters.output.persistence.repository.PricesRepository;
import com.test.micro.domain.model.Price;
import com.test.micro.ports.output.PricesPersistenceOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * Implementación de la interfaz PricesPersistenceOutputPort
 */
@Service
@AllArgsConstructor
public class PricesPersistenceAdapter implements PricesPersistenceOutputPort {

    /**
     * Inyección del servicio PricesRepository
     */
    private PricesRepository pricesRepository;

    /**
     * Inyección del mapper PriceEntityMapper
     */
    private PriceEntityMapper priceEntityMapper;

    /**
     * Este método obtiene un listado de los detalles del precio de un producto
     *
     * @param productId El identificador del producto
     * @param brandId El identificador de la marca
     * @param applicationDate La fecha de aplicación
     * @return List<Price> El listado del modelo con los detalles del precio
     */
    @Override
    public List<Price> getPriceBy(Integer productId, Integer brandId,
                                  Instant applicationDate) {
        return priceEntityMapper.toDomainFromEntity(
                pricesRepository.findByApplicationDateAndBrandIdAndProductId(productId,
                        brandId, applicationDate));
    }

}
