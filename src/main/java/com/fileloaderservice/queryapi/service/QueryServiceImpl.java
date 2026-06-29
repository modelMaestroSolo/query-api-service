package com.fileloaderservice.queryapi.service;

import com.fileloaderservice.queryapi.dto.CdrRecordResponse;
import com.fileloaderservice.queryapi.dto.CrdQueryRequest;
import com.fileloaderservice.queryapi.repository.CdrQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService{

    private final CdrQueryRepository repository;

    public QueryServiceImpl(CdrQueryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CdrRecordResponse> query(CrdQueryRequest request) {
        if (request.recordDateStart().isAfter(request.recordDateEnd())){
            throw new IllegalArgumentException(
                    "record_date_start must not be after record_date_end");
        }
        return repository.findRecords(
                request.recordDateStart(),
                request.recordDateEnd(),
                request.msisdn(),
                request.imsi()
        );
    }
}
