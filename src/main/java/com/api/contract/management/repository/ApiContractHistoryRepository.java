package com.api.contract.management.repository;

import com.api.contract.management.base.repository.BaseJpaRepository;
import com.api.contract.management.entity.ApiContract;
import com.api.contract.management.entity.ApiContractHistory;

import java.util.UUID;

public interface ApiContractHistoryRepository extends BaseJpaRepository<ApiContractHistory, UUID> {
}
