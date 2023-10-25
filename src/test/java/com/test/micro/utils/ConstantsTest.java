package com.test.micro.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Clase que contiene las constantes usadas en los test
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantsTest {

    //Integration constants test
    public static final String GET_PRICE_BY = "/price/{productId}";
    public static final String BRAND_ID_PARAM = "brandId";
    public static final String APPLICATION_DATE_PARAM = "applicationDate";
    public static final String GET_PRICE_99_99_RESPONSE = "file:src/test/resources/fixtures/responses/get-price-99_99.json";
    public static final String GET_PRICE_54_99_RESPONSE = "file:src/test/resources/fixtures/responses/get-price-54_99.json";
    public static final String GET_PRICE_70_50_RESPONSE = "file:src/test/resources/fixtures/responses/get-price-70_50.json";
    public static final String GET_PRICE_85_25_RESPONSE = "file:src/test/resources/fixtures/responses/get-price-85_25.json";


    //Commons constants test
    public static final Integer PRODUCT_ID = 12345;
    public static final Integer PRICE_ID = 1;
    public static final String CURRENCY = "EUR";
    public static final String BRAND_NAME = "BRAND_TEST";
    public static final Integer BRAND_ID = 1;
    public static final Integer FEE_ID_ONE = 1;
    public static final String FEE_ID_ONE_NAME = "FEE_ALL_YEAR";
    public static final Integer FEE_ID_TWO = 2;
    public static final Integer FEE_ID_THREE = 3;
    public static final Integer FEE_ID_FOUR = 4;
    public static final Double PRICE_99_99 = 99.99;
    public static final Double PRICE_54_99 = 54.99;
    public static final Double PRICE_70_50 = 70.50;
    public static final Double PRICE_85_25 = 85.25;
    public static final String APPLICATION_DATE_15_01_HOUR_13 = "2023/01/15 13:00:00";
    public static final String APPLICATION_DATE_21_03_HOUR_11 = "2023/03/21 11:00:00";
    public static final String APPLICATION_DATE_17_08_HOUR_14 = "2023/08/17 14:00:00";
    public static final String APPLICATION_DATE_24_11_HOUR_09 = "2023/11/24 09:00:00";
    public static final String START_DATE_01_01_HOUR_10_30 = "1/1/23 10:30";
    public static final String START_DATE_19_3_HOUR_12 = "19/3/23 12:00";
    public static final String START_DATE_11_08_HOUR_9_30 = "11/8/23 9:30";
    public static final String START_DATE_01_11_HOUR_00 = "1/11/23 00:00";
    public static final String END_DATE_18_08_HOUR_14 = "18/8/23 14:00";
    public static final String END_DATE_31_12_HOUR_23_59 = "31/12/23 23:59";
    public static final String END_DATE_25_03_HOUR_21 = "25/3/23 21:00";
    public static final String END_DATE_30_11_HOUR_13 = "30/11/23 13:00";
    public static final Date START_DATE = new Date();
    public static final Date END_DATE = new Date();
    public static final Integer ZERO_INDEX = 0;

}
