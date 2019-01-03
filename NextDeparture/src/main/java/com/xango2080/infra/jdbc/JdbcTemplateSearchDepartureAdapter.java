package com.xango2080.infra.jdbc;

import com.xango2080.domain.model.NextDeparture;
import com.xango2080.domain.model.NextDepartureBuilder;
import com.xango2080.domain.repository.SearchDeparture;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class JdbcTemplateSearchDepartureAdapter implements SearchDeparture {

    private final JdbcTemplate jdbcTemplate;
    private static final String QUERY = "";

    public JdbcTemplateSearchDepartureAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<NextDeparture> findByStation(String station) {
        return jdbcTemplate.query(QUERY, new RowMapper<NextDeparture>() {
            @Nullable
            @Override
            public NextDeparture mapRow(ResultSet resultSet, int i) throws SQLException {
                return NextDepartureBuilder.builder().build();
            }
        });
    }
}
