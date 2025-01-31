package com.api.contract.management.repository;

import com.api.contract.management.base.repository.BaseJpaRepository;
import com.api.contract.management.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeamRepository extends BaseJpaRepository<Team, UUID> {
    List<Team> findByDivisionId(UUID divisionId);

    Optional<Team> findByIdAndDivisionId(UUID id, UUID divisionId);

    Page<Team> findByNameLikeIgnoreCase(String search, Pageable pageable);
}
