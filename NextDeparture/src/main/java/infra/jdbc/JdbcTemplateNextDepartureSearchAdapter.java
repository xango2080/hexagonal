package infra.jdbc;

import domain.model.NextDeparture;
import domain.model.NextDepartureSearchQuery;
import domain.repository.NextDepartureSearch;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

public class JdbcTemplateNextDepartureSearchAdapter implements NextDepartureSearch {

    private final JdbcTemplate jdbcTemplate;
    private static final String QUERY = "";

    public JdbcTemplateNextDepartureSearchAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<NextDeparture> retrieveNext(NextDepartureSearchQuery query) {
        return Collections.emptyList();
    }
}
