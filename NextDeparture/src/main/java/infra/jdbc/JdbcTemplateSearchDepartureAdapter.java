package infra.jdbc;

import domain.model.NextDeparture;
import domain.model.NextDepartureBuilder;
import domain.repository.SearchDeparture;
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
    public Collection<NextDeparture> retrieveNext(String station) {
        return jdbcTemplate.query(QUERY, new RowMapper<NextDeparture>() {
            @Nullable
            @Override
            public NextDeparture mapRow(ResultSet resultSet, int i) throws SQLException {
                return NextDepartureBuilder.builder().build();
            }
        });
    }
}
