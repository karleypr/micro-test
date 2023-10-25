package com.test.micro.adapters.input.rest;

import com.test.micro.adapters.input.rest.dto.PriceDTO;
import com.test.micro.adapters.input.rest.mapper.PriceRestMapper;
import com.test.micro.ports.input.GetPriceUseCase;
import com.test.micro.utils.ConverterDate;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * El adaptador de entrada de tipo REST; hace uso de los casos de uso GetPriceUseCase, del mapper PriceRestMapper
 * y de la clase Converter. Controlador de Spring Boot encargado de atender las peticiones HTTP para obtener los
 * detalles del precio de un producto. Implementa la interfaz PriceApi.
 */
@Slf4j
@RestController
@AllArgsConstructor
public class PriceRestAdapter implements PriceApi {

    /**
     * Inyección del servicio GetPriceUseCase
     */
    private GetPriceUseCase getPriceUseCase;

    /**
     * Inyección del mapper PriceRestMapper
     */
    private PriceRestMapper priceRestMapper;

    /**
     * Inyección de la utilidad ConverterDate
     */
    private ConverterDate converter;

    /**
     * GET /price/{productId} : Get price by
     *
     * @param productId       The name of the product identifier. (required)
     * @param brandId         The name of the brand identifier. (required)
     * @param applicationDate Application date. (required)
     * @return successful operation (status code 200)
     * or Bad request (status code 400)
     * or Price not found (status code 404)
     */
    @SneakyThrows
    @Override
    public ResponseEntity<PriceDTO> getPriceBy(Integer productId, Integer brandId, String applicationDate) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(priceRestMapper.toPriceDtoFromPricesDomain(getPriceUseCase.getPriceBy(productId, brandId,
                                converter.instantConverterFromString(applicationDate))
                        )
                );
    }
}
