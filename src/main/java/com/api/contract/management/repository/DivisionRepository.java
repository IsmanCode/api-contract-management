package com.api.contract.management.repository;

import com.api.contract.management.base.repository.BaseJpaRepository;
import com.api.contract.management.entity.Division;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DivisionRepository extends BaseJpaRepository<Division, UUID> {
    Page<Division> findByNameLikeIgnoreCase(String search, Pageable pageable);
}
