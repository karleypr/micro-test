package com.test.micro.utils;

import com.test.micro.adapters.input.rest.dto.PriceDTO;
import com.test.micro.domain.model.Brand;
import com.test.micro.domain.model.Fee;
import com.test.micro.domain.model.Price;

import java.util.Date;

/**
 * Clase que contiene los mocks para los test unitarios
 */
public class MockTest {

    /**
     * Mock priceDTO
     *
     * @param productId El identificador del producto
     * @param brandId El identificador de la marca
     * @param feeId El identificador de la tarifa
     * @param startDate La fecha de inicio
     * @param endDate La fecha de finalización
     * @param price El precio
     * @return PriceDTO El DTO con los detalles del precio mockeado
     */
    public PriceDTO priceDTO(Integer productId, Integer brandId, Integer feeId,
                             String startDate, String endDate, Double price){
        return new PriceDTO().productId(productId)
                .brandId(brandId)
                .feeId(feeId)
                .startDate(startDate)
                .endDate(endDate)
                .price(price);
    }

    /**
     * Mock Price
     *
     * @param priceId El identificador del producto
     * @param startDate La fecha de inicio
     * @param endDate La fecha de finalización
     * @param productId El identificador del producto
     * @param priority La prioridad del precio
     * @param price El precio
     * @param currency La divisa
     * @param brandId El identificador de la marca
     * @param brandName El nombre de la marca
     * @param feeId El identificador de la tarifa
     * @param feeName El nombre de la tarifa
     * @return Price El modelo con los detalles del precio mockeado
     */
    public Price price(Integer priceId, Date startDate, Date endDate, Integer productId, Boolean priority,
                       Double price, String currency, Integer brandId, String brandName, Integer feeId, String feeName){
        return Price.builder().priceId(priceId)
                .startDate(startDate)
                .endDate(endDate)
                .productId(productId)
                .priority(priority)
                .price(price)
                .currency(currency)
                .brand(brand(brandId, brandName))
                .fee(fee(feeId, feeName)).build();
    }

    /**
     * Mock brand
     *
     * @param brandId El identificador de la marca
     * @param brandName El nombre de la marca
     * @return Brand el modelo con los detalles de la marca
     */
    public Brand brand(Integer brandId, String brandName){
        return Brand.builder().brandId(brandId)
                .brandName(brandName).build();
    }

    /**
     * Mock fee
     *
     * @param feeId El identificador de la tarifa
     * @param feeName El nombre de la tarifa
     * @return Fee el modelo con los detalles de la tarifa
     */
    public Fee fee(Integer feeId, String feeName){
        return Fee.builder().feeId(feeId)
                .feeName(feeName).build();
    }



}
