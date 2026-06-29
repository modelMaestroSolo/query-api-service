package com.fileloaderservice.queryapi.controller;

import com.fileloaderservice.queryapi.dto.CdrRecordResponse;
import com.fileloaderservice.queryapi.dto.CrdQueryRequest;
import com.fileloaderservice.queryapi.service.QueryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cdr")
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/query")
    public List<CdrRecordResponse> query(@Valid @RequestBody CrdQueryRequest request){
        return queryService.query(request);
    }
}
