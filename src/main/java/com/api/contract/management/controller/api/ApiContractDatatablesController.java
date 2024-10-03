package com.api.contract.management.controller.api;

import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiContractDatatablesController {

    @GetMapping(value = "/api-contract/datatables")
    public DataTableResults historyListDatatables(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        DataTableRequest dataTableRequest = new DataTableRequest(httpServletRequest);

        int page = dataTableRequest.getPage();
        int limit = dataTableRequest.getLength();

        String search = (dataTableRequest.getSearch() == null ? "":dataTableRequest.getSearch());

        String sortDirection = dataTableRequest.getOrder().getSortDir();

        Pageable pageable = null;

        if (sortDirection.equalsIgnoreCase("DESC")) {
            pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "modifiedAt"));
        }else if (sortDirection.equalsIgnoreCase("ASC")){
            pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.ASC, "modifiedAt"));
        }else {
            pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "modifiedAt"));

        }

        Page pageDocArchive = null;
//        pageDocArchive = docArchiveService.findAllByName(search,pageable);

        List archiveList = pageDocArchive.getContent();

        DataTableResults dataTableResults = new DataTableResults();

        dataTableResults.setListOfDataObjects(archiveList);
        dataTableResults.setDraw(dataTableRequest.getDraw());
        if (!archiveList.isEmpty()) {
            dataTableResults.setRecordsTotal(String.valueOf(pageDocArchive.getTotalElements()));
            dataTableResults.setRecordsFiltered(String.valueOf(pageDocArchive.getTotalElements()));
        }

        return dataTableResults;
    }

}
