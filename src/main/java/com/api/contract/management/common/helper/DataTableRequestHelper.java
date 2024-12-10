package com.api.contract.management.common.helper;

import com.api.contract.management.common.util.DataTableUtil;
import com.api.contract.management.dto.datatable.*;
import lombok.NoArgsConstructor;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class DataTableRequestHelper {

    /**
     * Prepare data table request.
     *
     * @param request the request
     */
    private static DataTableRequest prepareDataTableRequest(HttpServletRequest request) {

        DataTableRequest dataTableRequest = new DataTableRequest(request);

        Enumeration<String> parameterNames = request.getParameterNames();

        if(parameterNames.hasMoreElements()) {

            dataTableRequest.setStart(Integer.parseInt(DataTableUtil.getParameter(request, PaginationCriteria.PAGE_NO,0)));
            dataTableRequest.setLength(Integer.parseInt(DataTableUtil.getParameter(request,PaginationCriteria.PAGE_SIZE,10)));
            dataTableRequest.setUniqueId(request.getParameter("_"));
            dataTableRequest.setDraw(request.getParameter(PaginationCriteria.DRAW));

            dataTableRequest.setSearch(request.getParameter("search[value]"));
            dataTableRequest.setRegex(Boolean.valueOf(request.getParameter("search[regex]")));

            int sortableCol = Integer.parseInt(DataTableUtil.getParameter(request,"order[0][column]",0));

            List<DataTableColumnSpecs> columns = new ArrayList<DataTableColumnSpecs>();

            if(!DataTableUtil.isObjectEmpty(dataTableRequest.getSearch())) {
                dataTableRequest.setGlobalSearch(true);
            }

            int maxParamsToCheck = getNumberOfColumns(request);

            for(int i=0; i < maxParamsToCheck; i++) {
                if(null != request.getParameter("columns["+ i +"][data]")
                        && !"null".equalsIgnoreCase(request.getParameter("columns["+ i +"][data]"))
                        && !DataTableUtil.isObjectEmpty(request.getParameter("columns["+ i +"][data]"))) {
                    DataTableColumnSpecs colSpec = new DataTableColumnSpecs(request, i);
                    if(i == sortableCol) {
                        dataTableRequest.setOrder(colSpec);
                    }
                    columns.add(colSpec);

                    if(!DataTableUtil.isObjectEmpty(colSpec.getSearch())) {
                        dataTableRequest.setGlobalSearch(false);
                    }
                }
            }

            if(!DataTableUtil.isObjectEmpty(columns)) {
                dataTableRequest.setColumns(columns);
            }
        }
        return dataTableRequest;
    }

    private static int getNumberOfColumns(HttpServletRequest request) {
        Pattern p = Pattern.compile("columns\\[[0-9]+\\]\\[data\\]");
        @SuppressWarnings("rawtypes")
        Enumeration params = request.getParameterNames();
        List<String> lstOfParams = new ArrayList<String>();
        while(params.hasMoreElements()){
            String paramName = (String)params.nextElement();
            Matcher m = p.matcher(paramName);
            if(m.matches())	{
                lstOfParams.add(paramName);
            }
        }
        return lstOfParams.size();
    }
}
