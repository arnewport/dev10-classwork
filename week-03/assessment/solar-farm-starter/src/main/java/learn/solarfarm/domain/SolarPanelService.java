package learn.solarfarm.domain;

import learn.solarfarm.data.DataAccessException;
import learn.solarfarm.data.SolarPanelRepository;
import learn.solarfarm.models.SolarPanel;

import java.time.Year;
import java.util.List;

public class SolarPanelService {
    public final static int MAX_ROW_COLUMN = 250;

    private final SolarPanelRepository repository;

    public SolarPanelService(SolarPanelRepository repository) {
        this.repository = repository;
    }

    public static int getMaxInstallationYear() {
        return Year.now().getValue();
    }

    public List<SolarPanel> findBySection(String section) throws DataAccessException {
        return repository.findBySection(section);
    }

    public SolarPanel findByKey(String section, int row, int column) throws DataAccessException {
        return repository.findByKey(section, row, column);
    }

    public SolarPanelResult create(SolarPanel panel) throws DataAccessException {
        SolarPanelResult result = validate(panel);

        if (panel != null && panel.getId() > 0) {
            result.addErrorMessage("SolarPanel `id` should not be set.");
        }

        if (result.isSuccess()) {
            panel = repository.create(panel);
            result.setSolarPanel(panel);
        }

        return result;
    }

    // TODO: add an update method
    public SolarPanelResult update(SolarPanel panel) throws DataAccessException {
        SolarPanelResult result = validate(panel);

//        if (panel == null) {
//            result.addErrorMessage(String.format("There is no panel %s", panel.getKey()));
//        }

        if (panel.getId() <= 0) {
            result.addErrorMessage("SolarPanel `id` is required.");
        }

        if (result.isSuccess()) {
            if (repository.update(panel)) {
                result.setSolarPanel(panel);
            } else {
                String message = String.format("SolarPanel id %s was not found.", panel.getId());
                result.addErrorMessage(message);
            }
        }
        return result;
    }

    // TODO: add a delete method (possibly deleteById?)
    public SolarPanelResult deleteById(int panelId) throws DataAccessException {
        SolarPanelResult result = new SolarPanelResult();
        if (!repository.deleteById(panelId)) {
            String message = String.format("SolarPanel id %s was not found.", panelId);
            result.addErrorMessage(message);
        }
        return result;
    }

    private SolarPanelResult validate(SolarPanel panel) throws DataAccessException {
        SolarPanelResult result = new SolarPanelResult();

        if (panel == null) {
            result.addErrorMessage("SolarPanel cannot be null.");
            return result;
        }

        if (panel.getSection() == null || panel.getSection().isBlank()) {
            result.addErrorMessage("SolarPanel `section` is required.");
        }

        if (panel.getRow() < 1 || panel.getRow() >= MAX_ROW_COLUMN) {
            result.addErrorMessage("SolarPanel `row` must be a positive number less than or equal to %s.", MAX_ROW_COLUMN);
        }

        if (panel.getColumn() < 1 || panel.getColumn() >= MAX_ROW_COLUMN) {
            result.addErrorMessage("SolarPanel `column` must be a positive number less than or equal to %s.", MAX_ROW_COLUMN);
        }

        if (panel.getYearInstalled() > getMaxInstallationYear()) {
            result.addErrorMessage("SolarPanel `yearInstalled` must be in the past.");
        }

        if (panel.getMaterial() == null) {
            result.addErrorMessage("SolarPanel `material` is required.");
        }

        // If everything is successful so far, then check if the combined values
        // of **Section**, **Row**, and **Column** are unique (i.e. the natural key).
        if (result.isSuccess()) {
            SolarPanel existingSolarPanel = repository.findByKey(panel.getSection(),
                    panel.getRow(), panel.getColumn());

            // If an existing panel was found for the provided **Section**, **Row**, and **Column** values
            // add an error message if the id values don't match (i.e. they're not the same record).
            if (existingSolarPanel != null && existingSolarPanel.getId() != panel.getId()) {
                result.addErrorMessage("SolarPanel `section`, `row`, and `column` must be unique.");
            }
        }

        return result;
    }
}
