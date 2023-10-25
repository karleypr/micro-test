package com.test.micro.output.persistence;

import com.test.micro.adapters.output.persistence.PricesPersistenceAdapter;
import com.test.micro.adapters.output.persistence.mapper.PriceEntityMapper;
import com.test.micro.adapters.output.persistence.repository.PricesRepository;
import com.test.micro.domain.model.Price;
import com.test.micro.utils.ConstantsTest;
import com.test.micro.utils.MockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Clase que contiene los test unitarios de la clase PricesPersistenceAdapter
 */
@SpringBootTest()
public class PricesPersistenceAdapterTest {

    /**
     * InjectMocks de PricesPersistenceAdapter clase a testear
     */
    @InjectMocks
    private PricesPersistenceAdapter pricesPersistenceAdapter;

    /**
     * Mock de PricesRepository para ser burlado
     */
    @Mock
    private PricesRepository pricesRepository;

    /**
     * Mock de PriceEntityMapper para ser burlado
     */
    @Mock
    private PriceEntityMapper priceEntityMapper;

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
        when(this.priceEntityMapper.toDomainFromEntity(any()))
                .thenReturn(Collections.singletonList(mockTest.price(ConstantsTest.PRICE_ID, ConstantsTest.START_DATE,
                        ConstantsTest.END_DATE, ConstantsTest.PRODUCT_ID, Boolean.FALSE,
                        ConstantsTest.PRICE_99_99,
                        ConstantsTest.CURRENCY, ConstantsTest.BRAND_ID, ConstantsTest.BRAND_NAME,
                        ConstantsTest.FEE_ID_ONE, ConstantsTest.FEE_ID_ONE_NAME)));

        List<Price> result = pricesPersistenceAdapter.getPriceBy(ConstantsTest.PRODUCT_ID,
                ConstantsTest.BRAND_ID, Instant.now());

        assertNotNull(result);

        assertEquals(ConstantsTest.PRODUCT_ID, result.get(ConstantsTest.ZERO_INDEX).getProductId());
        assertEquals(ConstantsTest.BRAND_ID, result.get(ConstantsTest.ZERO_INDEX).getBrand().getBrandId());
        assertEquals(ConstantsTest.FEE_ID_ONE, result.get(ConstantsTest.ZERO_INDEX).getFee().getFeeId());
        assertEquals(ConstantsTest.PRICE_99_99, result.get(ConstantsTest.ZERO_INDEX).getPrice());

    }
}
