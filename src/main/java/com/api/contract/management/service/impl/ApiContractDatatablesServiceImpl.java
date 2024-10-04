package com.api.contract.management.service.impl;

import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import com.api.contract.management.dto.response.ApiContractDatatableResponse;
import com.api.contract.management.entity.ApiContract;
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

        Pageable pageable = null;

        if (sortDirection.equalsIgnoreCase("DESC")) {
            pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "updatedDate"));
        }else if (sortDirection.equalsIgnoreCase("ASC")){
            pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.ASC, "updatedDate"));
        }else {
            pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "updatedDate"));

        }

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
                    response.setDivisionTitle(data.getProject().getDivision().getTitle());
                    response.setTeamTitle(data.getProject().getTeam().getTitle());
                    response.setProjectTitle(data.getProject().getTitle());
                    response.setCreatedDate(data.getCreatedDate());
                    response.setUpdatedDate(data.getUpdatedDate());
                    response.setCreatedBy(data.getCreatedBy());
                    response.setUpdatedBy(data.getUpdatedBy());
                    return response;
                }).toList();
    }
}
