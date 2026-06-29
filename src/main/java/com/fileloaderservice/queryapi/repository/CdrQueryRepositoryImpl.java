package com.fileloaderservice.queryapi.repository;


import com.fileloaderservice.queryapi.dto.CdrRecordResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CdrQueryRepositoryImpl implements CdrQueryRepository{

    private final JdbcTemplate jdbc;

    public CdrQueryRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<CdrRecordResponse> rowMapper = (rs, rowNum) -> {
        Timestamp recordDate = rs.getTimestamp("record_date");

        return new CdrRecordResponse(
                recordDate == null ? null : recordDate.toLocalDateTime(),
                rs.getString("msisdn"),
                rs.getString("imsi")
        );
    };


    @Override
    public List<CdrRecordResponse> findRecords(LocalDateTime recordDateStart, LocalDateTime recordDateEnd, String msisdn, String imsi) {
        StringBuilder sql = new StringBuilder("SELECT record_date, msisdn, imsi " +
                                              "FROM call_detail_records " +
                                              "WHERE record_date BETWEEN ? AND ? ");
        List<Object> params = new ArrayList<>();
        params.add(Timestamp.valueOf(recordDateStart));
        params.add(Timestamp.valueOf(recordDateEnd));

        if (StringUtils.hasText(msisdn)) {
            sql.append(" AND msisdn = ? ");
            params.add(msisdn);
        }

        if (StringUtils.hasText(imsi)) {
            sql.append(" AND imsi = ? ");
            params.add(imsi);
        }

        return jdbc.query(sql.toString(), rowMapper, params.toArray());
    }
}
