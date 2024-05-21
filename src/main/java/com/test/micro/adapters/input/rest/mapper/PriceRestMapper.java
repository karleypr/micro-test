package com.test.micro.adapters.input.rest.mapper;

import com.test.micro.adapters.input.rest.dto.PriceDTO;
import com.test.micro.domain.model.Price;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Esta clase representa un mapper entre DTO y Modelo
 */
@Mapper(componentModel = "spring")
public interface PriceRestMapper {

    /**
     * To Price Dto From Prices Domain
     *
     * @param pricesDomain El modelo
     * @return PriceDTO el DTO con la respuesta del mapper
     */
    PriceDTO toPriceDtoFromPricesDomain(Price pricesDomain);

    /**
     * To Price Dto list From Prices Domain list
     *
     * @param pricesDomain El modelo
     * @return List<PriceDTO> lista de el DTO con la respuesta del mapper
     */
    List<PriceDTO> toPriceDtoListFromPricesDomainList(List<Price> pricesDomain);

    /**
     * Mapper que se ejecuta después del mapper toPriceDtoFromPricesDomain
     *
     * @param pricesDomain El modelo
     * @param priceDTO el DTO dónde se va a mapear la respuesta
     */
    @AfterMapping
    default void afterMappingToPriceDtoFromPricesDomain(Price pricesDomain, @MappingTarget PriceDTO priceDTO) {
        priceDTO.setBrandId(pricesDomain.getBrand().getBrandId());
        priceDTO.setFeeId(pricesDomain.getFee().getFeeId());
    }

}