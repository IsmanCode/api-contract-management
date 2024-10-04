package com.api.contract.management.controller.api;

import com.api.contract.management.common.util.ObjectMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class SwaggerStoreController {
    @PostMapping("/swagger-store")
    public ResponseEntity doExecute(@RequestBody String jsonSpec) throws InterruptedException {
        log.debug("jsonSpec: {}", jsonSpec);
        Map<String,Object> map = ObjectMapperUtil.convertToObject(jsonSpec,Map.class);
        return ResponseEntity.ok(map);
    }
}
