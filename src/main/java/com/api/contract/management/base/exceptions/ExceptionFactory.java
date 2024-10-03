package com.api.contract.management.base.exceptions;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;

public interface ExceptionFactory {

    AbstractException buildException(BaseExceptionRequest exception);

}
