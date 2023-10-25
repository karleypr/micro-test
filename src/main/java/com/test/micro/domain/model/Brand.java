package com.test.micro.domain.model;

import lombok.*;

/**
 * Modelo de la marca
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {

    /**
     * Identificador de la marca
     */
    private Integer brandId;

    /**
     * Nombre de la marca
     */
    private String brandName;

}
