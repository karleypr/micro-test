package com.test.micro.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

/**
 * Esta clase representa una utilidad para convertir fechas
 */
@Component
public class ConverterDate {

    /**
     * Este método convierte una fecha de tipo String a tipo Instant
     *
     * @param applicationDate La fecha de aplicación a convertir
     * @return Instant La fecha de aplicación convertida a tipo Instant
     */
    public Instant instantConverterFromString(String applicationDate) throws ParseException {
        return new SimpleDateFormat(Constants.DATE_CONVERTER_PATTERN)
                .parse(applicationDate).toInstant();
    }

}
