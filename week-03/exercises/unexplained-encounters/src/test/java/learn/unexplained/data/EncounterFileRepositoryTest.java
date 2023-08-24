package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterFileRepositoryTest {

    static final String SEED_PATH = "./data/encounters-seed.csv";
    static final String TEST_PATH = "./data/encounters-test.csv";

    EncounterRepository repository = new EncounterFileRepository(TEST_PATH);

    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(SEED_PATH);
        Path testPath = Paths.get(TEST_PATH);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<Encounter> actual = repository.findAll();
        assertEquals(3, actual.size());
    }

    @Test
    void shouldFindByType() throws DataAccessException {
        List<Encounter> actual = repository.findByType(EncounterType.UFO);
        assertEquals(1, actual.size()); // seed data has 1 UFO type

        actual = repository.findByType(EncounterType.VOICE);
        assertEquals(0, actual.size()); // seed data has 0 VOICE types
    }

    @Test
    void shouldFindById() throws DataAccessException {
        Encounter encounter = repository.findById(1);
        assertNotNull(encounter);
        assertEquals("2020-01-01", encounter.getWhen());

        encounter = repository.findById(1024);
        assertNull(encounter); // id 1024 does not exist, expect null
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = new Encounter();
        encounter.setType(EncounterType.UFO);
        encounter.setWhen("Jan 15, 2005");
        encounter.setDescription("moving pinpoint of light." +
                "seemed to move with me along the highway. " +
                "then suddenly reversed direction without slowing down. it just reversed.");
        encounter.setOccurrences(1);

        Encounter actual = repository.add(encounter);

        assertNotNull(actual);
        assertEquals(4, actual.getEncounterId());
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        Encounter encounter = repository.findById(2);
        encounter.setWhen("Oct 19, 1997");
        assertTrue(repository.update(encounter));

        encounter = repository.findById(2);
        assertNotNull(encounter);                        // confirm the encounter exists
        assertEquals("Oct 19, 1997", encounter.getWhen());    // confirm the encounter was updated

        Encounter doesNotExist = new Encounter();
        doesNotExist.setEncounterId(1024);
        assertFalse(repository.update(doesNotExist)); // can't update a encounter that doesn't exist
    }

    @Test
    void shouldDeleteById() throws DataAccessException {
        int count = repository.findAll().size();
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(1024));
        assertEquals(count - 1, repository.findAll().size());
    }

}