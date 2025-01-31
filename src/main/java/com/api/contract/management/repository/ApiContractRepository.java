package com.api.contract.management.repository;

import com.api.contract.management.base.repository.BaseJpaRepository;
import com.api.contract.management.entity.ApiContract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApiContractRepository extends BaseJpaRepository<ApiContract, UUID> {

    Page<ApiContract> findByNameLikeIgnoreCase(String name, Pageable pageable);

}
