package com.api.contract.management.base.specification;

import com.api.contract.management.base.dto.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class BaseSpecification<T> implements Specification<T> {

    private SearchCriteria criteria;

    public BaseSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Nullable
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            if (getDynamicFieldPath(criteria.getKey(), root).getJavaType() == Date.class) {
                return criteriaBuilder.greaterThanOrEqualTo(getDynamicFieldPath(criteria.getKey(), root), (Date) criteria.getValue());
            } else if (getDynamicFieldPath(criteria.getKey(), root).getJavaType() == LocalDate.class) {
                return criteriaBuilder.greaterThanOrEqualTo(getDynamicFieldPath(criteria.getKey(), root), (LocalDate) criteria.getValue());
            } else if (getDynamicFieldPath(criteria.getKey(), root).getJavaType() == Instant.class) {
                return criteriaBuilder.greaterThanOrEqualTo(getDynamicFieldPath(criteria.getKey(), root), (Instant) criteria.getValue());
            } else if (getDynamicFieldPath(criteria.getKey(), root).getJavaType() == Instant.class) {
                return criteriaBuilder.greaterThanOrEqualTo(getDynamicFieldPath(criteria.getKey(), root), (Instant) criteria.getValue());
            } else {
                return criteriaBuilder.greaterThanOrEqualTo(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            }
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {

            if (getDynamicFieldPath(criteria.getKey(), root).getJavaType() == Date.class) {
                return criteriaBuilder.lessThanOrEqualTo(getDynamicFieldPath(criteria.getKey(), root), (Date) criteria.getValue());
            } else if (getDynamicFieldPath(criteria.getKey(), root).getJavaType() == LocalDate.class) {
                return criteriaBuilder.lessThanOrEqualTo(getDynamicFieldPath(criteria.getKey(), root), (LocalDate) criteria.getValue());
            } else if (getDynamicFieldPath(criteria.getKey(), root).getJavaType() == Instant.class) {
                return criteriaBuilder.lessThanOrEqualTo(getDynamicFieldPath(criteria.getKey(), root), (Instant) criteria.getValue());
            } else if (getDynamicFieldPath(criteria.getKey(), root).getJavaType() == Instant.class) {
                return criteriaBuilder.lessThanOrEqualTo(getDynamicFieldPath(criteria.getKey(), root), (Instant) criteria.getValue());
            } else {
                return criteriaBuilder.lessThanOrEqualTo(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            }

        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (getDynamicFieldPath(criteria.getKey(), root).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        getDynamicFieldPath(criteria.getKey(), root), "%" + criteria.getValue() + "%");
            } else {
                return criteriaBuilder.equal(getDynamicFieldPath(criteria.getKey(), root), criteria.getValue());
            }
        } else if (criteria.getOperation().equalsIgnoreCase("in")) {
            return getDynamicFieldPath(criteria.getKey(), root).in(criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase("!in")) {
            return getDynamicFieldPath(criteria.getKey(), root).in(criteria.getValue()).not();
        }
        return null;
    }

    private <R> Path<R> getDynamicFieldPath(String key, Root<T> root) {
        Path<R> fieldPath = null;
        if (key.contains(".")) {
            String[] fields = key.split("\\.");
            for (String field : fields) {
                if (fieldPath == null) {
                    fieldPath = root.get(field);
                } else {
                    fieldPath = fieldPath.get(field);
                }
            }
        } else {
            fieldPath = root.get(key);
        }
        return fieldPath;
    }

}
