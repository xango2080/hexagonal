package infra.jdbc;

import domain.model.NextDeparture;
import domain.repository.NextDepartureRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

public class JdbcTemplateNextDepartureRepositoryAdapter implements NextDepartureRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final String QUERY = "";

    public JdbcTemplateNextDepartureRepositoryAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<NextDeparture> retrieveNext(String station, Instant departureTime, long maxResults) {
        return Collections.emptyList();
    }
}
