package com.api.contract.management.service.impl;

import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import com.api.contract.management.dto.response.TeamDatatableResponse;
import com.api.contract.management.entity.Team;
import com.api.contract.management.entity.Division;
import com.api.contract.management.entity.Project;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.TeamRepository;
import com.api.contract.management.service.contract.TeamDatatablesService;
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
public class TeamDatatablesServiceImpl implements TeamDatatablesService {

    private final TeamRepository apiContractRepository;

    @Override
    public DataTableResults<TeamDatatableResponse> execute(DataTableRequest<TeamDatatableResponse> request) {
        log.debug("TeamDatatablesServiceImpl: {}", request);
        int page = request.getPage();
        int limit = request.getLength();

        String search = "%" + (request.getSearch() == null ? "":request.getSearch()) + "%";

        String sortDirection = request.getOrder().getSortDir();

        Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "updatedDate"));

        Page<Team> pageData = apiContractRepository.findByNameLikeIgnoreCase(search,pageable);

        List<TeamDatatableResponse> dataList = buildContractList(pageData);

        DataTableResults<TeamDatatableResponse> dataTableResults = new DataTableResults();

        dataTableResults.setListOfDataObjects(dataList);
        dataTableResults.setDraw(request.getDraw());
        if (!dataList.isEmpty()) {
            dataTableResults.setRecordsTotal(String.valueOf(pageData.getTotalElements()));
            dataTableResults.setRecordsFiltered(String.valueOf(pageData.getTotalElements()));
        }
        return dataTableResults;
    }

    private List<TeamDatatableResponse> buildContractList(Page<Team> page) {
        return page.stream()
                .map(data -> {
                    TeamDatatableResponse response = new TeamDatatableResponse();
                    BeanUtils.copyProperties(data,response);
                    response.setId(data.getId());
                    String divisionTitle = Optional.ofNullable(data.getDivision())
                            .map(Division::getTitle).orElse("");
                    response.setDivisionTitle(divisionTitle);
                    response.setCreatedDate(data.getCreatedDate());
                    response.setUpdatedDate(data.getUpdatedDate());
                    response.setCreatedBy(data.getCreatedBy());
                    response.setUpdatedBy(data.getUpdatedBy());
                    return response;
                }).toList();
    }
}
