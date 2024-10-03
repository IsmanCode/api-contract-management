package com.api.contract.management.base.exceptions.catcher;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;
import com.api.contract.management.base.exceptions.AbstractException;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataNotFoundExceptionKafka implements AbstractException {

    @Override
    public String buildResponse(BaseExceptionRequest exception) {

        if (exception.getException() instanceof DataNotFoundException data) {

            return "Kafka Retrun Value";
        }

        throw new RuntimeException("not handle exception",exception.getException());
    }
}
