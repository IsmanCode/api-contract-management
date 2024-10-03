package com.api.contract.management.repository;

import com.api.contract.management.base.repository.BaseJpaRepository;
import com.api.contract.management.entity.ApiContract;

import java.util.UUID;

public interface ApiContractRepository extends BaseJpaRepository<ApiContract, UUID> {
}
