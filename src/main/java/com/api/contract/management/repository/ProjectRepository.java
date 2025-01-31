package com.api.contract.management.repository;

import com.api.contract.management.base.repository.BaseJpaRepository;
import com.api.contract.management.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends BaseJpaRepository<Project, UUID> {

    List<Project> findByTeamId(UUID teamId);

    Optional<Project> findByIdAndTeamId(UUID id, UUID teamId);

    Page<Project> findByNameLikeIgnoreCase(String search, Pageable pageable);
}
