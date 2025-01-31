package com.api.contract.management.service.impl;

import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import com.api.contract.management.dto.response.DivisionDatatableResponse;
import com.api.contract.management.entity.Division;
import com.api.contract.management.entity.Division;
import com.api.contract.management.entity.Project;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.DivisionRepository;
import com.api.contract.management.service.contract.DivisionDatatablesService;
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
public class DivisionDatatablesServiceImpl implements DivisionDatatablesService {

    private final DivisionRepository divisionRepository;

    @Override
    public DataTableResults<DivisionDatatableResponse> execute(DataTableRequest<DivisionDatatableResponse> request) {
        log.debug("DivisionDatatablesServiceImpl: {}", request);
        int page = request.getPage();
        int limit = request.getLength();

        String search = "%" + (request.getSearch() == null ? "":request.getSearch()) + "%";

        String sortDirection = request.getOrder().getSortDir();

        Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "updatedDate"));

        Page<Division> pageData = divisionRepository.findByNameLikeIgnoreCase(search,pageable);

        List<DivisionDatatableResponse> dataList = buildContractList(pageData);

        DataTableResults<DivisionDatatableResponse> dataTableResults = new DataTableResults();

        dataTableResults.setListOfDataObjects(dataList);
        dataTableResults.setDraw(request.getDraw());
        if (!dataList.isEmpty()) {
            dataTableResults.setRecordsTotal(String.valueOf(pageData.getTotalElements()));
            dataTableResults.setRecordsFiltered(String.valueOf(pageData.getTotalElements()));
        }
        return dataTableResults;
    }

    private List<DivisionDatatableResponse> buildContractList(Page<Division> page) {
        return page.stream()
                .map(data -> {
                    DivisionDatatableResponse response = new DivisionDatatableResponse();
                    BeanUtils.copyProperties(data,response);
                    response.setCreatedDate(data.getCreatedDate());
                    response.setUpdatedDate(data.getUpdatedDate());
                    response.setCreatedBy(data.getCreatedBy());
                    response.setUpdatedBy(data.getUpdatedBy());
                    return response;
                }).toList();
    }
}
