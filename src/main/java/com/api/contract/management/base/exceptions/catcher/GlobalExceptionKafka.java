package com.api.contract.management.base.exceptions.catcher;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;
import com.api.contract.management.base.exceptions.AbstractException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GlobalExceptionKafka implements AbstractException {

    @Override
    public String buildResponse(BaseExceptionRequest exception) {


        return "Error Kafka global";
    }

}
