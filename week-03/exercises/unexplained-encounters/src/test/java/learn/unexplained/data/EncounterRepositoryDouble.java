package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.ArrayList;
import java.util.List;

public class EncounterRepositoryDouble implements EncounterRepository {

    private ArrayList<Encounter> encounters = new ArrayList<>();
    
    public EncounterRepositoryDouble() {
        encounters.add(new Encounter(1, EncounterType.UFO, "2020-01-01", "short test #1", 1));
        encounters.add(new Encounter(2, EncounterType.CREATURE, "2020-02-01", "short test #2", 1));
        encounters.add(new Encounter(3, EncounterType.SOUND, "2020-03-01", "short test #3", 1));
    }

    @Override
    public List<Encounter> findAll() throws DataAccessException {
        return new ArrayList<>(encounters);
    }

    @Override
    public Encounter findById(int encounterId) throws DataAccessException {
        for (Encounter m : encounters) {
            if (m.getEncounterId() == encounterId) {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Encounter> findByType(EncounterType type) throws DataAccessException {
        ArrayList<Encounter> result = new ArrayList<>();
        for (Encounter encounter : encounters) {
            if (encounter.getType() == type) {
                result.add(encounter);
            }
        }
        return result;
    }


    @Override
    public Encounter add(Encounter encounter) throws DataAccessException {
        return encounter;
    }

    @Override
    public boolean update(Encounter encounter) throws DataAccessException {
        return findById(encounter.getEncounterId()) != null;
    }

    @Override
    public boolean deleteById(int encounterId) throws DataAccessException {
        return findById(encounterId) != null;
    }
}
