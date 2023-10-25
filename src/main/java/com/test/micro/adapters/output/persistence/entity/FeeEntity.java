package com.test.micro.adapters.output.persistence.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Entidad de la tarifa
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "FEE")
public class FeeEntity {

    /**
     * Identificador de la tarfia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEE_ID", nullable = false)
    private Integer feeId;

    /**
     * Nombre de la tarfia
     */
    @Column(name = "FEE_NAME", nullable = false)
    private String feeName;

}