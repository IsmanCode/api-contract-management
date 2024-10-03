package com.api.contract.management.repository;

import com.api.contract.management.base.repository.BaseJpaRepository;
import com.api.contract.management.entity.Team;

import java.util.UUID;

public interface TeamRepository extends BaseJpaRepository<Team, UUID> {
}
