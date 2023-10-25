package com.test.micro.adapters.input.rest.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.micro.utils.ConstantsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.net.URL;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Clase que contiene los test de integración de la aplicación
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PriceRestAdapterIntegrationTest {

    /**
     * Inyección MockMvc
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Inyección ObjectMapper
     */
    private ObjectMapper objectMapper;

    /**
     * Método de inicialización
     */
    @BeforeEach
    public void buildMock() {
        objectMapper = new ObjectMapper();
    }

    /**
     * Método que obtiene json desde una ruta
     *
     * @param fileRoute La ruta del fichero
     * @return String Json
     */
    String getStringResponseFile(String fileRoute) throws IOException {
        Object json = objectMapper.readValue(new URL(fileRoute), Object.class);
        return objectMapper.writeValueAsString(json);
    }

    /**
     * Test de integración que obtiene los detalles del precio cuando la fecha
     * de aplicación es 2023/01/15 13:00:00
     */
    @Test
    void getPriceByWhenApplicationDateIsDay15_01Hour13Test() throws Exception {

        String expected = this.getStringResponseFile(
                ConstantsTest.GET_PRICE_99_99_RESPONSE);

        mockMvc.perform(
                        MockMvcRequestBuilders.get(ConstantsTest.GET_PRICE_BY, ConstantsTest.PRODUCT_ID)
                                .param(ConstantsTest.BRAND_ID_PARAM, ConstantsTest.BRAND_ID.toString())
                                .param(ConstantsTest.APPLICATION_DATE_PARAM,
                                        ConstantsTest.APPLICATION_DATE_15_01_HOUR_13))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    /**
     * Test de integración que obtiene los detalles del precio cuando la fecha
     * de aplicación es 2023/03/21 11:00:00
     */
    @Test
    void getPriceByWhenApplicationDateIsDay21_03Hour11Test() throws Exception {

        String expected = this.getStringResponseFile(
                ConstantsTest.GET_PRICE_54_99_RESPONSE);

        mockMvc.perform(
                        MockMvcRequestBuilders.get(ConstantsTest.GET_PRICE_BY, ConstantsTest.PRODUCT_ID)
                                .param(ConstantsTest.BRAND_ID_PARAM, ConstantsTest.BRAND_ID.toString())
                                .param(ConstantsTest.APPLICATION_DATE_PARAM,
                                        ConstantsTest.APPLICATION_DATE_21_03_HOUR_11))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    /**
     * Test de integración que obtiene los detalles del precio cuando la fecha
     * de aplicación es 2023/08/17 14:00:00
     */
    @Test
    void getPriceByWhenApplicationDateIsDay17_08Hour14Test() throws Exception {

        String expected = this.getStringResponseFile(
                ConstantsTest.GET_PRICE_70_50_RESPONSE);

        mockMvc.perform(
                        MockMvcRequestBuilders.get(ConstantsTest.GET_PRICE_BY, ConstantsTest.PRODUCT_ID)
                                .param(ConstantsTest.BRAND_ID_PARAM, ConstantsTest.BRAND_ID.toString())
                                .param(ConstantsTest.APPLICATION_DATE_PARAM,
                                        ConstantsTest.APPLICATION_DATE_17_08_HOUR_14))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    /**
     * Test de integración que obtiene los detalles del precio cuando la fecha
     * de aplicación es 2023/11/24 09:00:00
     */
    @Test
    void getPriceByWhenApplicationDateIsDay24_11Hour09Test() throws Exception {

        String expected = this.getStringResponseFile(
                ConstantsTest.GET_PRICE_85_25_RESPONSE);

        mockMvc.perform(
                        MockMvcRequestBuilders.get(ConstantsTest.GET_PRICE_BY, ConstantsTest.PRODUCT_ID)
                                .param(ConstantsTest.BRAND_ID_PARAM, ConstantsTest.BRAND_ID.toString())
                                .param(ConstantsTest.APPLICATION_DATE_PARAM,
                                        ConstantsTest.APPLICATION_DATE_24_11_HOUR_09))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }
}
