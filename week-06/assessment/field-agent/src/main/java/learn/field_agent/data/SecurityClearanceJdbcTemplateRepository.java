package learn.field_agent.data;

import learn.field_agent.data.mappers.AgencyAgentMapper;
import learn.field_agent.data.mappers.SecurityClearanceMapper;
import learn.field_agent.models.AgencyAgent;
import learn.field_agent.models.AgentAgency;
import learn.field_agent.models.SecurityClearance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class SecurityClearanceJdbcTemplateRepository implements SecurityClearanceRepository {

    private final JdbcTemplate jdbcTemplate;

    public SecurityClearanceJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SecurityClearance> findAll() {
        // limit until we develop a paging solution
        final String sql = "select security_clearance_id, name security_clearance_name " +
                "from security_clearance limit 1000;";
        return jdbcTemplate.query(sql, new SecurityClearanceMapper());
    }

    @Override
    public SecurityClearance findById(int securityClearanceId) {

        final String sql = "select security_clearance_id, name security_clearance_name "
                + "from security_clearance "
                + "where security_clearance_id = ?;";

        return jdbcTemplate.query(sql, new SecurityClearanceMapper(), securityClearanceId)
                .stream()
                .findFirst().orElse(null);
    }

    @Override
    public SecurityClearance add(SecurityClearance clearance) {

        final String sql = "insert into security_clearance (name) values (?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, clearance.getName());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        clearance.setSecurityClearanceId(keyHolder.getKey().intValue());
        return clearance;
    }

    @Override
    public boolean update(SecurityClearance clearance) {

        final String sql = "update security_clearance set "
                + "name = ? "
                + "where security_clearance_id = ?";

        return jdbcTemplate.update(sql, clearance.getName(), clearance.getSecurityClearanceId()) > 0;
    }

    @Override
    public boolean deleteById(int securityClearanceId) {
        return jdbcTemplate.update("delete from security_clearance where security_clearance_id = ?", securityClearanceId) > 0;
    }

    @Override
    public int countInstancesOfId(int securityClearanceId) {
        final String sql = "select count(*) " +
                "from agency_agent " +
                "where security_clearance_id = ?;";
        return jdbcTemplate.queryForObject(sql, Integer.class, securityClearanceId);
    }
    
}
