package com.test.micro.domain.model;

import lombok.*;

/**
 * Modelo de la tarifa
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fee {

    /**
     * Identificador de la tarfia
     */
    private Integer feeId;

    /**
     * Nombre de la tarfia
     */
    private String feeName;

}
