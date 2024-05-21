package com.test.micro.adapters.output.persistence.repository.impl;

import com.test.micro.adapters.output.persistence.entity.PriceEntity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel( PriceEntity.class )
public class PriceEntity_ {

    public static volatile SingularAttribute<PriceEntity, Boolean> priority;
    public static volatile SingularAttribute<PriceEntity, Integer> productId;
    public static volatile SingularAttribute<PriceEntity, String> currency;

    public static final String PRIORITY = "priority";
    public static final String PRODUCT_ID = "productId";
    public static final String CURRENCY = "currency";
}
