package com.test.micro.adapters.output.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

/**
 * Entidad del precio
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PRICE")
public class PriceEntity {

    /**
     * Identificador del precio
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_ID", nullable = false)
    private Integer priceId;

    /**
     * Fecha de inicio del precio
     */
    @Column(name = "START_DATE", nullable = false)
    private Instant startDate;

    /**
     * Fecha de finalización del precio
     */
    @Column(name = "END_DATE", nullable = false)
    private Instant endDate;

    /**
     * Identificador del producto
     */
    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    /**
     * Prioridad del precio
     */
    @Column(name = "PRIORITY", nullable = false)
    private Boolean priority;

    /**
     * Precio del producto
     */
    @Column(name = "PRICE", nullable = false)
    private Double price;

    /**
     * Divisa del precio
     */
    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    /**
     * Objeto que contiene los detalles de la marca
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "BRAND_ID_FK", nullable = false)
    private BrandEntity brand;

    /**
     * Objeto que contiene los detalles de la tarifa
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "FEE_ID_FK", nullable = false)
    private FeeEntity fee;

}
