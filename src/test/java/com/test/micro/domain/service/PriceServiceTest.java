package com.test.micro.domain.service;

import com.test.micro.domain.model.Price;
import com.test.micro.ports.output.PricesPersistenceOutputPort;
import com.test.micro.utils.ConstantsTest;
import com.test.micro.utils.MockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Clase que contiene los test unitarios de la clase PriceService
 */
@SpringBootTest()
public class PriceServiceTest {

    /**
     * InjectMocks de PriceService clase a testear
     */
    @InjectMocks
    private PriceService priceService;

    /**
     * Mock de PricesPersistenceOutputPort para ser burlado
     */
    @Mock
    private PricesPersistenceOutputPort pricesPersistenceOutputPort;

    /**
     * Inyección MockTest Clase que contiene objetos mock
     */
    private MockTest mockTest;

    /**
     * Método de inicialización
     */
    @BeforeEach
    public void buildMock() {
        mockTest = new MockTest();
    }

    /**
     * Test unitario que mockea los detalles del precio
     */
    @Test
    public void getPriceByWhenPriceIs99_99Test() {
        when(this.pricesPersistenceOutputPort.getPriceBy(any(), any(), any()))
                .thenReturn(Collections.singletonList(mockTest.price(ConstantsTest.PRICE_ID,
                        ConstantsTest.START_DATE, ConstantsTest.END_DATE,
                        ConstantsTest.PRODUCT_ID, Boolean.FALSE,
                        ConstantsTest.PRICE_99_99,
                        ConstantsTest.CURRENCY, ConstantsTest.BRAND_ID, ConstantsTest.BRAND_NAME,
                        ConstantsTest.FEE_ID_ONE, ConstantsTest.FEE_ID_ONE_NAME)));

        Price result = priceService.getPriceBy(ConstantsTest.PRODUCT_ID,
                ConstantsTest.BRAND_ID, Instant.now());

        assertNotNull(result);

        assertEquals(ConstantsTest.PRODUCT_ID, result.getProductId());
        assertEquals(ConstantsTest.BRAND_ID, result.getBrand().getBrandId());
        assertEquals(ConstantsTest.FEE_ID_ONE, result.getFee().getFeeId());
        assertEquals(ConstantsTest.PRICE_99_99,
                result.getPrice());
    }
}
