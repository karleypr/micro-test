package com.test.micro.adapters.output.persistence.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Entidad de la marca
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "BRAND")
public class BrandEntity {

    /**
     * Identificador de la marca
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID", nullable = false)
    private Integer brandId;

    /**
     * Nombre de la marca
     */
    @Column(name = "BRAND_NAME", nullable = false)
    private String brandName;

}