package com.test.micro.adapters.output.persistence.repository.impl;

import com.test.micro.adapters.output.persistence.entity.PriceEntity;
import com.test.micro.adapters.output.persistence.repository.PricesRepositoryCustom;
import com.test.micro.domain.model.Fields;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class PricesRepositoryImpl implements PricesRepositoryCustom {

    private final EntityManager em;

    /**
     * Este método obtiene los detalles del precio de un producto mediante filtros
     *
     * @param fields filtros para realizar la consulta
     * @return List<Price> El listado del modelo con los detalles del precio
     */
    @Override
    public List<PriceEntity> getPrinceByFilters(Fields fields) {

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<PriceEntity> cq = builder.createQuery(PriceEntity.class);

        Root<PriceEntity> root = cq.from(PriceEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(fields.getPriority())){
            predicates.add(
                    builder.equal(
                            root.get(PriceEntity_.PRIORITY), fields.getPriority()));
        }

        if (Objects.nonNull(fields.getProductId())){
            predicates.add(
                    builder.equal(
                            root.get(PriceEntity_.PRODUCT_ID), fields.getProductId()));
        }

        if (Objects.nonNull(fields.getCurrency())){
            predicates.add(
                    builder.equal(
                            root.get(PriceEntity_.CURRENCY), fields.getCurrency()));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<PriceEntity> query = em.createQuery(cq);

        return query.getResultList();
    }
}
