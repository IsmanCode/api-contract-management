package com.api.contract.management.base.exceptions.catcher;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.base.exceptions.AbstractException;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataNotFoundExceptionHttp implements AbstractException {

    @Override
    public ResponseEntity buildResponse(BaseExceptionRequest exception) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        if (exception.getException() instanceof DataNotFoundException data) {

            return ResponseEntity
                            .status(HttpStatus.valueOf(data.getHttpStatusCode()))
                            .body(
                                    BaseResponse.builder()
                                            .errors(data.getErrors())
                                            .build()
                            );
        }

        throw new RuntimeException("not handle exception",exception.getException());
    }
}
