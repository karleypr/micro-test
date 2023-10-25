package com.test.micro.adapters.input.rest.unit;


import com.test.micro.adapters.input.rest.PriceRestAdapter;
import com.test.micro.adapters.input.rest.dto.PriceDTO;
import com.test.micro.adapters.input.rest.mapper.PriceRestMapper;
import com.test.micro.ports.input.GetPriceUseCase;
import com.test.micro.utils.ConstantsTest;
import com.test.micro.utils.ConverterDate;
import com.test.micro.utils.MockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Clase que contiene los test unitarios de la clase PriceRestAdapter
 */
@SpringBootTest()
public class PriceRestAdapterTest {

    /**
     * InjectMocks de PriceRestAdapter clase a testear
     */
    @InjectMocks
    private PriceRestAdapter priceRestAdapter;

    /**
     * Mock de GetPriceUseCase para ser burlado
     */
    @Mock
    private GetPriceUseCase getPriceUseCase;

    /**
     * Mock de PriceRestMapper para ser burlado
     */
    @Mock
    private PriceRestMapper priceRestMapper;

    /**
     * Mock de ConverterDate para ser burlado
     */
    @Mock
    private ConverterDate converter;

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
     * Test unitario que mockea los detalles del precio cuando la fecha
     * de aplicación es 2023/01/15 13:00:00
     */
    @Test
    public void getPriceByWhenApplicationDateIsDay15_01_Hour13Test() {
        when(this.priceRestMapper.toPriceDtoFromPricesDomain(any()))
                .thenReturn(mockTest.priceDTO(ConstantsTest.PRODUCT_ID, ConstantsTest.BRAND_ID,
                        ConstantsTest.FEE_ID_ONE, ConstantsTest.START_DATE_01_01_HOUR_10_30,
                        ConstantsTest.END_DATE_31_12_HOUR_23_59,
                        ConstantsTest.PRICE_99_99));

        ResponseEntity<PriceDTO> result = priceRestAdapter.getPriceBy(ConstantsTest.PRODUCT_ID,
                ConstantsTest.BRAND_ID, ConstantsTest.APPLICATION_DATE_15_01_HOUR_13);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.PRODUCT_ID, result.getBody().getProductId());
        assertEquals(ConstantsTest.BRAND_ID, result.getBody().getBrandId());
        assertEquals(ConstantsTest.FEE_ID_ONE, result.getBody().getFeeId());
        assertEquals(ConstantsTest.START_DATE_01_01_HOUR_10_30, result.getBody().getStartDate());
        assertEquals(ConstantsTest.END_DATE_31_12_HOUR_23_59, result.getBody().getEndDate());
        assertEquals(ConstantsTest.PRICE_99_99,
                result.getBody().getPrice());

    }

    /**
     * Test unitario que mockea los detalles del precio cuando la fecha
     * de aplicación es 2023/03/21 11:00:00
     */
    @Test
    public void getPriceByWhenApplicationDateIsDay21_03Hour11Test() {
        when(this.priceRestMapper.toPriceDtoFromPricesDomain(any()))
                .thenReturn(mockTest.priceDTO(ConstantsTest.PRODUCT_ID, ConstantsTest.BRAND_ID,
                        ConstantsTest.FEE_ID_TWO, ConstantsTest.START_DATE_19_3_HOUR_12,
                        ConstantsTest.END_DATE_25_03_HOUR_21,
                        ConstantsTest.PRICE_54_99));

        ResponseEntity<PriceDTO> result = priceRestAdapter.getPriceBy(ConstantsTest.PRODUCT_ID,
                ConstantsTest.BRAND_ID, ConstantsTest.APPLICATION_DATE_21_03_HOUR_11);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.PRODUCT_ID, result.getBody().getProductId());
        assertEquals(ConstantsTest.BRAND_ID, result.getBody().getBrandId());
        assertEquals(ConstantsTest.FEE_ID_TWO, result.getBody().getFeeId());
        assertEquals(ConstantsTest.START_DATE_19_3_HOUR_12, result.getBody().getStartDate());
        assertEquals(ConstantsTest.END_DATE_25_03_HOUR_21, result.getBody().getEndDate());
        assertEquals(ConstantsTest.PRICE_54_99,
                result.getBody().getPrice());

    }

    /**
     * Test unitario que mockea los detalles del precio cuando la fecha
     * de aplicación es 2023/06/14 21:00:00
     */
    /*@Test
    public void getPriceByWhenApplicationDateIsDay14Hour21Test() {
        when(this.priceRestMapper.toPriceDtoFromPricesDomain(any()))
                .thenReturn(mockTest.priceDTO(ConstantsTest.PRODUCT_ID, ConstantsTest.BRAND_ID,
                        ConstantsTest.FEE_ID_ONE, ConstantsTest.START_DATE_14_06_HOUR_00,
                        ConstantsTest.END_DATE_31_12_HOUR_23_59_1,
                        ConstantsTest.PRICE_99_99));

        ResponseEntity<PriceDTO> result = priceRestAdapter.getPriceBy(ConstantsTest.PRODUCT_ID,
                ConstantsTest.BRAND_ID, ConstantsTest.APPLICATION_DATE_29_05_HOUR_17);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.PRODUCT_ID, result.getBody().getProductId());
        assertEquals(ConstantsTest.BRAND_ID, result.getBody().getBrandId());
        assertEquals(ConstantsTest.FEE_ID_ONE, result.getBody().getFeeId());
        assertEquals(ConstantsTest.START_DATE_14_06_HOUR_00, result.getBody().getStartDate());
        assertEquals(ConstantsTest.END_DATE_31_12_HOUR_23_59_1, result.getBody().getEndDate());
        assertEquals(ConstantsTest.PRICE_99_99,
                result.getBody().getPrice());

    }*/

    /**
     * Test unitario que mockea los detalles del precio cuando la fecha
     * de aplicación es 2023/08/17 14:00:00
     */
    @Test
    public void getPriceByWhenApplicationDateIsDay17_08Hour14Test() {
        when(this.priceRestMapper.toPriceDtoFromPricesDomain(any()))
                .thenReturn(mockTest.priceDTO(ConstantsTest.PRODUCT_ID, ConstantsTest.BRAND_ID,
                        ConstantsTest.FEE_ID_THREE, ConstantsTest.START_DATE_11_08_HOUR_9_30,
                        ConstantsTest.END_DATE_18_08_HOUR_14,
                        ConstantsTest.PRICE_70_50));

        ResponseEntity<PriceDTO> result = priceRestAdapter.getPriceBy(ConstantsTest.PRODUCT_ID,
                ConstantsTest.BRAND_ID, ConstantsTest.APPLICATION_DATE_17_08_HOUR_14);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.PRODUCT_ID, result.getBody().getProductId());
        assertEquals(ConstantsTest.BRAND_ID, result.getBody().getBrandId());
        assertEquals(ConstantsTest.FEE_ID_THREE, result.getBody().getFeeId());
        assertEquals(ConstantsTest.START_DATE_11_08_HOUR_9_30, result.getBody().getStartDate());
        assertEquals(ConstantsTest.END_DATE_18_08_HOUR_14, result.getBody().getEndDate());
        assertEquals(ConstantsTest.PRICE_70_50,
                result.getBody().getPrice());

    }

    /**
     * Test unitario que mockea los detalles del precio cuando la fecha
     * de aplicación es 2023/11/24 09:00:00
     */
    @Test
    public void getPriceByWhenApplicationDateIsDay24_11Hour09Test() {
        when(this.priceRestMapper.toPriceDtoFromPricesDomain(any()))
                .thenReturn(mockTest.priceDTO(ConstantsTest.PRODUCT_ID, ConstantsTest.BRAND_ID,
                        ConstantsTest.FEE_ID_FOUR, ConstantsTest.START_DATE_01_11_HOUR_00,
                        ConstantsTest.END_DATE_30_11_HOUR_13,
                        ConstantsTest.PRICE_85_25));

        ResponseEntity<PriceDTO> result = priceRestAdapter.getPriceBy(ConstantsTest.PRODUCT_ID,
                ConstantsTest.BRAND_ID, ConstantsTest.APPLICATION_DATE_24_11_HOUR_09);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ConstantsTest.PRODUCT_ID, result.getBody().getProductId());
        assertEquals(ConstantsTest.BRAND_ID, result.getBody().getBrandId());
        assertEquals(ConstantsTest.FEE_ID_FOUR, result.getBody().getFeeId());
        assertEquals(ConstantsTest.START_DATE_01_11_HOUR_00, result.getBody().getStartDate());
        assertEquals(ConstantsTest.END_DATE_30_11_HOUR_13, result.getBody().getEndDate());
        assertEquals(ConstantsTest.PRICE_85_25,
                result.getBody().getPrice());

    }
}
