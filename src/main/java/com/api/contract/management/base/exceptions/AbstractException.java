package com.api.contract.management.base.exceptions;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;

public interface AbstractException {

    <T> T buildResponse(BaseExceptionRequest exception);

}
