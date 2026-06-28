package com.fileloaderservice.queryapi.service;

import com.fileloaderservice.queryapi.dto.CdrRecordResponse;
import com.fileloaderservice.queryapi.dto.CrdQueryRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface QueryService {
    List<CdrRecordResponse> query(@Valid CrdQueryRequest request);
}
