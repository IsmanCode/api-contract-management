package com.api.contract.management.service.impl;

import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import com.api.contract.management.dto.response.ApiContractDatatableResponse;
import com.api.contract.management.entity.ApiContract;
import com.api.contract.management.entity.Division;
import com.api.contract.management.entity.Project;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.ApiContractRepository;
import com.api.contract.management.service.contract.ApiContractDatatablesService;
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
public class ApiContractDatatablesServiceImpl implements ApiContractDatatablesService {

    private final ApiContractRepository apiContractRepository;

    @Override
    public DataTableResults<ApiContractDatatableResponse> execute(DataTableRequest<ApiContractDatatableResponse> request) {
        log.debug("ApiContractDatatablesServiceImpl: {}", request);
        int page = request.getPage();
        int limit = request.getLength();

        String search = "%" + (request.getSearch() == null ? "":request.getSearch()) + "%";

        String sortDirection = request.getOrder().getSortDir();

        Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "updatedDate"));

        Page<ApiContract> pageData = apiContractRepository.findByNameLikeIgnoreCase(search,pageable);

        List<ApiContractDatatableResponse> dataList = buildContractList(pageData);

        DataTableResults<ApiContractDatatableResponse> dataTableResults = new DataTableResults();

        dataTableResults.setListOfDataObjects(dataList);
        dataTableResults.setDraw(request.getDraw());
        if (!dataList.isEmpty()) {
            dataTableResults.setRecordsTotal(String.valueOf(pageData.getTotalElements()));
            dataTableResults.setRecordsFiltered(String.valueOf(pageData.getTotalElements()));
        }
        return dataTableResults;
    }

    private List<ApiContractDatatableResponse> buildContractList(Page<ApiContract> page) {
        return page.stream()
                .map(data -> {
                    ApiContractDatatableResponse response = new ApiContractDatatableResponse();
                    BeanUtils.copyProperties(data,response);
                    response.setId(data.getId());
                    String divisionTitle = Optional.ofNullable(data.getProject())
                            .map(Project::getTeam).map(Team::getDivision).map(Division::getTitle).orElse("");
                    response.setDivisionTitle(divisionTitle);
                    String teamTitle = Optional.ofNullable(data.getProject())
                            .map(Project::getTeam).map(Team::getTitle).orElse("");
                    response.setTeamTitle(teamTitle);
                    String projectTitle = Optional.ofNullable(data.getProject())
                            .map(Project::getTitle).orElse("");
                    response.setProjectTitle(projectTitle);
                    response.setStatus(data.getStatus());
                    response.setCreatedDate(data.getCreatedDate());
                    response.setUpdatedDate(data.getUpdatedDate());
                    response.setCreatedBy(data.getCreatedBy());
                    response.setUpdatedBy(data.getUpdatedBy());
                    return response;
                }).toList();
    }
}
