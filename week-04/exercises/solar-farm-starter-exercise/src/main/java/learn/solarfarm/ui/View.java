package learn.solarfarm.ui;

import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;

import java.util.List;

public class View {
    private final TextIO io;

    public View(TextIO io) {
        this.io = io;
    }

    public int chooseMenuOption() {
        displayHeader("Main Menu");
        io.println("0. Exit");
        io.println("1. Find Panels by Section");
        io.println("2. Add a Panel");
        io.println("3. Update a Panel");
        io.println("4. Remove a Panel");
        return io.readInt("Choose [0-4]", 0, 4);
    }

    public String getSection() {
        io.println("");
        return io.readRequiredString("Section Name");
    }

    public void displaySolarPanels(String section, List<SolarPanel> solarPanels) {
        io.println("");
        io.printf("Panels in %s%n", section);
        io.println("Row Col Year Material Tracking");
        for (SolarPanel sp : solarPanels) {
            io.printf("%3s %3s %4s %8s %8s%n", sp.getRow(), sp.getColumn(), sp.getYearInstalled(),
                    sp.getMaterial(), sp.isTracking() ? "yes" : "no");
        }
    }

    public void displayHeader(String message) {
        int length = message.length();
        io.println("");
        io.println(message);
        io.println("=".repeat(length));
    }

    public void displayErrors(List<String> errors) {
        displayMessage("[Errors]");
        for (String error : errors) {
            io.println(error);
        }
    }

    public void displayMessage(String message) {
        io.println("");
        io.println(message);
    }

    public void displayMessage(String format, Object... args) {
        displayMessage(String.format(format, args));
    }

    public SolarPanel enterSectionRowColumn() {
        io.println("");

        SolarPanel result = new SolarPanel();
        result.setSection(io.readRequiredString("Section"));
        result.setRow(io.readInt("Row", 1, SolarPanelService.MAX_ROW_COLUMN));
        result.setColumn(io.readInt("Column", 1, SolarPanelService.MAX_ROW_COLUMN));

        return result;
    }

    public SolarPanel addSolarPanel() {
        SolarPanel result = enterSectionRowColumn();
        result.setMaterial(io.readEnum("Material", Material.class));
        result.setYearInstalled(io.readInt("Installation Year", SolarPanelService.getMaxInstallationYear()));
        result.setTracking(io.readBoolean("Tracked [y/n]"));

        return result;
    }

    public SolarPanel updateSolarPanel(SolarPanel result) {
        io.println("");

        String value = io.readString(String.format("Section (%s)", result.getSection()));
        // the ternary operator can be placed inside setSection()
        value = (value.isEmpty()) ? result.getSection() : value;
        result.setSection(value);

        result.setRow(io.readIntWhileAllowingEmpty(String.format("Row (%s)", result.getRow()), 1, SolarPanelService.MAX_ROW_COLUMN, result.getRow()));
        result.setColumn(io.readIntWhileAllowingEmpty(String.format("Column (%s)", result.getColumn()), 1, SolarPanelService.MAX_ROW_COLUMN, result.getColumn()));
        result.setMaterial(io.readEnumWhileAllowingEmpty(String.format("Material (%s)", result.getMaterial().getName()), Material.class, result.getMaterial()));
        result.setYearInstalled(io.readIntWhileAllowingEmpty(String.format("Installation Year (%s)", result.getYearInstalled()), SolarPanelService.getMaxInstallationYear(), result.getYearInstalled()));
        result.setTracking(io.readBooleanWhileAllowingEmpty(String.format("Tracked (%s) [y/n]", result.isTracking() ? "yes" : "no"), result.isTracking()));

        return result;
    }

}
