package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import com.api.contract.management.dto.response.ProjectDatatableResponse;

public interface ProjectDatatablesService extends Command<DataTableRequest<ProjectDatatableResponse>, DataTableResults<ProjectDatatableResponse>> {
}
