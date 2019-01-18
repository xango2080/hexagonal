package com.xango.nextdeparture.app.gateway.jdbc;

import com.xango.nextdeparture.domain.model.NextDeparture;
import com.xango.nextdeparture.domain.model.search.NextDepartureSearchQuery;
import com.xango.nextdeparture.domain.gateway.SearchNextDeparture;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;
import java.util.Collections;

public class JdbcTemplateSearchNextDepartureAdapter implements SearchNextDeparture {

    private final JdbcTemplate jdbcTemplate;
    private static final String QUERY = "";

    public JdbcTemplateSearchNextDepartureAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<NextDeparture> retrieveNext(NextDepartureSearchQuery query) {
        return Collections.emptyList();
    }
}
