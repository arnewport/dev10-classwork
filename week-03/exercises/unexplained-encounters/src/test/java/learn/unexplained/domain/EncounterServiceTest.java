package learn.unexplained.domain;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.data.EncounterRepositoryDouble;
import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterServiceTest {

    EncounterService service;

    @BeforeEach
    void setup() {
        EncounterRepositoryDouble repository = new EncounterRepositoryDouble();
        service = new EncounterService(repository);
    }

    @Test
    void shouldFindOneUFO() throws DataAccessException {
        List<Encounter> encounters = service.findByType(EncounterType.UFO);
        assertEquals(1, encounters.size());
    }

    @Test
    void shouldFindZeroVoice() throws DataAccessException {
        List<Encounter> encounters = service.findByType(EncounterType.VOICE);
        assertEquals(0, encounters.size());
    }

    @Test
    void shouldNotAddNull() throws DataAccessException {
        EncounterResult expected = makeResult("encounter cannot be null");
        EncounterResult actual = service.add(null);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddEmptyWhen() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, " ", "test desc", 1);
        EncounterResult expected = makeResult("when is required");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddEmptyDescription() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", "  ", 1);
        EncounterResult expected = makeResult("description is required");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddNullDescription() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", null, 1);
        EncounterResult expected = makeResult("description is required");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddZeroOccurrences() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", "test description", 0);
        EncounterResult expected = makeResult("occurrences must be greater than 0");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddDuplicate() throws DataAccessException {
        Encounter encounter = new Encounter(1, EncounterType.UFO, "2020-01-01", "short test #1", 1);
        EncounterResult expected = makeResult("duplicate encounter is not allowed");
        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = new Encounter(0, EncounterType.CREATURE, "2/2/2019", "test description", 1);
        EncounterResult expected = new EncounterResult();
        expected.setPayload(encounter);

        EncounterResult actual = service.add(encounter);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFailValidation() throws DataAccessException {
        Encounter encounter = new Encounter(1, EncounterType.UFO, "2020-01-01", "short test #1", 0);

        EncounterResult result = service.update(encounter);

        assertFalse(result.isSuccess());
    }

    // does this count? Or should I be checking for an actual null value?
    @Test
    void shouldNotUpdateNonexistentEncounter() throws DataAccessException {
        Encounter encounter = new Encounter(-1, EncounterType.UFO, "2020-01-01", "short test #1", 0);
        EncounterResult result = service.update(encounter);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        Encounter encounter = service.findAll().get(0);
        encounter.setDescription("updated content");

        EncounterResult result = service.update(encounter);

        assertTrue(result.isSuccess());
    }

    @Test
    void shouldDelete() throws DataAccessException {
        EncounterResult result = service.deleteById(1);
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotDelete() throws DataAccessException {
        EncounterResult result = service.deleteById(1024);
        assertFalse(result.isSuccess());
    }

    private EncounterResult makeResult(String message) {
        EncounterResult result = new EncounterResult();
        result.addErrorMessage(message);
        return result;
    }
}