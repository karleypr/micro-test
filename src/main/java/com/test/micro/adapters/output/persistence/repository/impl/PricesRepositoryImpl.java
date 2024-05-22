package com.test.micro.adapters.output.persistence.repository.impl;

import com.test.micro.adapters.output.persistence.entity.PriceEntity;
import com.test.micro.adapters.output.persistence.repository.PricesRepositoryCustom;
import com.test.micro.domain.model.Fields;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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

        CriteriaQuery<Object[]> cq = builder.createQuery(Object[].class);

        Root<PriceEntity> root = cq.from(PriceEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        List<Selection> selections = new ArrayList<>();

        if (Objects.nonNull(fields.getPriority())){
            selections.add(root.get(PriceEntity_.PRIORITY));

            predicates.add(
                    builder.equal(
                            root.get(PriceEntity_.PRIORITY), fields.getPriority()));
        }

        if (Objects.nonNull(fields.getProductId())){
            selections.add(root.get(PriceEntity_.PRODUCT_ID));

            predicates.add(
                    builder.equal(
                            root.get(PriceEntity_.PRODUCT_ID), fields.getProductId()));
        }

        if (Objects.nonNull(fields.getCurrency())){
            selections.add(root.get(PriceEntity_.CURRENCY));

            predicates.add(
                    builder.equal(
                            root.get(PriceEntity_.CURRENCY), fields.getCurrency()));
        }

        if (Objects.nonNull(fields.getPrice())){
            selections.add(root.get(fields.getPrice()));
        }

        cq.multiselect(selections.toArray(new Selection[0]));

        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Object[]> query = em.createQuery(cq);

        List<Object[]> results = query.getResultList();

        List<PriceEntity> priceEntities = new ArrayList<>();
        for (Object[] result : results) {
            PriceEntity priceEntity = new PriceEntity();

            int index = 0;

            if (Objects.nonNull(fields.getPriority())) {
                priceEntity.setPriority((Boolean) result[index++]);
            }
            if (Objects.nonNull(fields.getProductId())) {
                priceEntity.setProductId((Integer) result[index++]);
            }
            if (Objects.nonNull(fields.getCurrency())) {
                priceEntity.setCurrency((String) result[index++]);
            }
            if (Objects.nonNull(fields.getPrice())) {
                priceEntity.setPrice((Double) result[index++]);
            }

            priceEntities.add(priceEntity);
        }

        return priceEntities;
    }

}
