package com.api.contract.management.base.dto.response;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class BasePageResponse<T> implements Serializable {

    private List<T> results = new ArrayList<>();

    private PaginationResponse paging;

}
