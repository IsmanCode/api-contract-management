package com.api.contract.management.service.impl;

import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import com.api.contract.management.dto.response.ProjectDatatableResponse;
import com.api.contract.management.entity.Project;
import com.api.contract.management.entity.Division;
import com.api.contract.management.entity.Project;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.ProjectRepository;
import com.api.contract.management.service.contract.ProjectDatatablesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectDatatablesServiceImpl implements ProjectDatatablesService {

    private final ProjectRepository projectRepository;

    @Override
    public DataTableResults<ProjectDatatableResponse> execute(DataTableRequest<ProjectDatatableResponse> request) {
        log.debug("ProjectDatatablesServiceImpl: {}", request);
        int page = request.getPage();
        int limit = request.getLength();

        String search = "%" + (request.getSearch() == null ? "":request.getSearch()) + "%";

        String sortDirection = request.getOrder().getSortDir();

        Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "updatedDate"));

        Page<Project> pageData = projectRepository.findByNameLikeIgnoreCase(search,pageable);

        List<ProjectDatatableResponse> dataList = buildContractList(pageData);

        DataTableResults<ProjectDatatableResponse> dataTableResults = new DataTableResults();

        dataTableResults.setListOfDataObjects(dataList);
        dataTableResults.setDraw(request.getDraw());
        if (!dataList.isEmpty()) {
            dataTableResults.setRecordsTotal(String.valueOf(pageData.getTotalElements()));
            dataTableResults.setRecordsFiltered(String.valueOf(pageData.getTotalElements()));
        }
        return dataTableResults;
    }

    private List<ProjectDatatableResponse> buildContractList(Page<Project> page) {
        return page.stream()
                .map(data -> {
                    ProjectDatatableResponse response = new ProjectDatatableResponse();
                    BeanUtils.copyProperties(data,response);
                    response.setId(data.getId());
                    String teamTitle = Optional.ofNullable(data.getTeam())
                            .map(Team::getTitle).orElse("");
                    response.setTeamTitle(teamTitle);
                    response.setCreatedDate(data.getCreatedDate());
                    response.setUpdatedDate(data.getUpdatedDate());
                    response.setCreatedBy(data.getCreatedBy());
                    response.setUpdatedBy(data.getUpdatedBy());
                    return response;
                }).toList();
    }
}
