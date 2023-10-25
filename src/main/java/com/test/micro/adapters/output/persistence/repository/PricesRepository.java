package com.test.micro.adapters.output.persistence.repository;

import com.test.micro.adapters.output.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

/**
 * Interfaz PricesRepository que hereda de CrudRepository
 */
@Repository
public interface PricesRepository extends CrudRepository<PriceEntity, Long> {

    /**
     * Este método contiene la consulta que ataca a la base de datos en memoria H2 para
     * obtiener un listado de los detalles del precio de un producto
     *
     * @param productId El identificador del producto
     * @param brandId El identificador de la marca
     * @param applicationDate La fecha de aplicación
     * @return List<PriceEntity> El listado de la entidad con los detalles del precio
     */
    @Query("SELECT p, b, f " +
            "FROM PriceEntity p " +
            "LEFT JOIN BrandEntity b " +
            "ON p.brand = b.brandId " +
            "LEFT JOIN FeeEntity f " +
            "ON p.fee = f.feeId " +
            "WHERE p.productId = ?1 " +
            "AND b.brandId = ?2 " +
            "AND p.startDate <= ?3 " +
            "AND p.endDate >= ?3")
    List<PriceEntity> findByApplicationDateAndBrandIdAndProductId(Integer productId, Integer brandId,
                                                                  Instant applicationDate);
}
