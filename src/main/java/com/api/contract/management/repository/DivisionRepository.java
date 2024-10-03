package com.api.contract.management.repository;

import com.api.contract.management.base.repository.BaseJpaRepository;
import com.api.contract.management.entity.Division;

import java.util.UUID;

public interface DivisionRepository extends BaseJpaRepository<Division, UUID> {
}
