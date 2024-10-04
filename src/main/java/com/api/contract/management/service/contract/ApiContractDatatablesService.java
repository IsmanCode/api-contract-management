package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import com.api.contract.management.dto.response.ApiContractDatatableResponse;

public interface ApiContractDatatablesService extends Command<DataTableRequest<ApiContractDatatableResponse>, DataTableResults<ApiContractDatatableResponse>> {
}
