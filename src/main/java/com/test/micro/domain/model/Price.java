package com.test.micro.domain.model;

import lombok.*;

import java.util.Date;

/**
 * Modelo del precio
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {

    /**
     * Identificador del precio
     */
    private Integer priceId;

    /**
     * Fecha de inicio del precio
     */
    private Date startDate;

    /**
     * Fecha de finalización del precio
     */
    private Date endDate;

    /**
     * Identificador del producto
     */
    private Integer productId;

    /**
     * Prioridad del precio
     */
    private Boolean priority;

    /**
     * Precio del producto
     */
    private Double price;

    /**
     * Divisa del precio
     */
    private String currency;

    /**
     * Objeto que contiene los detalles de la marca
     */
    private Brand brand;

    /**
     * Objeto que contiene los detalles de la tarifa
     */
    private Fee fee;

}
