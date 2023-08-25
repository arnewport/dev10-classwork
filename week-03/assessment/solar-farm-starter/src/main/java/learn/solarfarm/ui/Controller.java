package learn.solarfarm.ui;

import learn.solarfarm.data.DataAccessException;
import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;

import java.util.List;

public class Controller {
    private final View view;
    private final SolarPanelService service;

    public Controller(View view, SolarPanelService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        view.displayHeader("Welcome to Solar Farm");
        try {
            runApp();
        } catch (DataAccessException ex) {
            view.displayErrors(List.of(ex.getMessage()));
        }
        view.displayMessage("Goodbye!");
    }

    private void runApp() throws DataAccessException {
        for (int option = view.chooseMenuOption();
             option > 0;
             option = view.chooseMenuOption()) {

            switch (option) {
                case 1:
                    findSolarPanelsBySection();
                    break;
                case 2:
                    addSolarPanel();
                    break;
                case 3:
                    updateSolarPanel();
                    break;
                case 4:
                    // TODO: complete delete
                    removeSolarPanel();
                    break;
            }
        }
    }

    private void findSolarPanelsBySection() throws DataAccessException {
        view.displayHeader("Find Panels by Section");
        String section = view.getSection();
        List<SolarPanel> solarPanels = service.findBySection(section);
        if (solarPanels.isEmpty()) {
            view.displayMessage("There are no panels in this section.");
        } else {
            view.displaySolarPanels(section, solarPanels);
        }
    }

    private void addSolarPanel() throws DataAccessException {
        view.displayHeader("Add a Panel");
        SolarPanel panel = view.addSolarPanel();
        SolarPanelResult result = service.create(panel);
        if (result.isSuccess()) {
            view.displayMessage("[Success]%nPanel %s added.", result.getSolarPanel().getKey());
        } else {
            view.displayErrors(result.getErrorMessages());
        }
    }

    private void updateSolarPanel() throws DataAccessException {
        view.displayHeader("Update a Panel");
        SolarPanel panel = view.enterSectionRowColumn();
        String panelKey = panel.getKey();
        panel = service.findByKey(panel.getSection(), panel.getRow(), panel.getColumn());

        // I don't think I should be doing validation in the controller
        // but... it works... for now. I will do it better later
        if (panel == null) {
            view.displayMessage("[Err]%nThere is no panel %s", panelKey);
            return;
        }

        view.displayMessage("Editing %s", panelKey);
        panel = view.updateSolarPanel(panel);
        SolarPanelResult result = service.update(panel);
        if (result.isSuccess()) {
            view.displayMessage("[Success]%nPanel %s updated.", panel.getKey());
        } else {
            view.displayErrors(result.getErrorMessages());
        }
        // TODO: grab the section, row, and column from the view.
        // TODO: use the service to fetch a solar panel by its key (section, row, column).
        // TODO: complete update
    }

    private void removeSolarPanel() throws DataAccessException {
        view.displayHeader("Remove a Panel");
        SolarPanel panel = view.enterSectionRowColumn();
        String panelKey = panel.getKey();
        panel = service.findByKey(panel.getSection(), panel.getRow(), panel.getColumn());

        // I don't think I should be doing validation in the controller
        // but... it works... for now. I will do it better later
        if (panel == null) {
            view.displayMessage(String.format("[Err]%nThere is no panel %s", panelKey));
            return;
        }

        SolarPanelResult result = service.deleteById(panel.getId());
        if (result.isSuccess()) {
            view.displayMessage("[Success]%nPanel %s removed.", panel.getKey());
        } else {
            view.displayErrors(result.getErrorMessages());
        }

    }

}
