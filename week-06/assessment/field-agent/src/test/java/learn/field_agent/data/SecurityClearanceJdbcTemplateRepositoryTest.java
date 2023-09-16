package learn.field_agent.data;

import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SecurityClearanceJdbcTemplateRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    SecurityClearanceJdbcTemplateRepository repository;
    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

// TODO: the code below (and an oddly constructed set_good_known_state) were causing issues
// TODO: I would like to understand how the code below is different from the code above

//    @Autowired
//    KnownGoodState knownGoodState;
//
//    @BeforeEach
//    void setup() {
//        knownGoodState.set();
//    }

    @Test
    void shouldFindAll() {
        List<SecurityClearance> clearances = repository.findAll();
        assertNotNull(clearances);
        assertEquals(2, clearances.size());
    }

    @Test
    void shouldFindById() {
        SecurityClearance actual = repository.findById(1);
        assertEquals("Secret", actual.getName());

        actual = repository.findById(2);
        assertEquals("Top Secret", actual.getName());

        actual = repository.findById(3);
        assertNull(actual);
    }

    @Test
    void shouldAdd() {
        SecurityClearance clearance = new SecurityClearance();
        clearance.setName("Double Top Secret");
        SecurityClearance actual = repository.add(clearance);
        assertNotNull(actual);
        assertEquals(3, actual.getSecurityClearanceId());
    }

    @Test
    void shouldUpdate() {
        SecurityClearance clearance = new SecurityClearance(1, "Confidential");
        assertTrue(repository.update(clearance));
    }

    @Test
    void shouldDeleteById() {
        assertTrue(repository.deleteById(2));
        assertFalse(repository.deleteById(2));
    }

    @Test
    void shouldCountInstancesOfId() {
        assertEquals(12, repository.countInstancesOfId(1));
        assertNotEquals(1, repository.countInstancesOfId(100));
    }

}