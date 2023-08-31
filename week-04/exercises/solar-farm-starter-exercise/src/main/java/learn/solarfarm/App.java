package learn.solarfarm;

import learn.solarfarm.data.SolarPanelFileRepository;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;
import learn.solarfarm.ui.ConsoleIO;
import learn.solarfarm.ui.Controller;
import learn.solarfarm.ui.View;

public class App {
    public static void main(String[] args) {
        // "./data/solarfarm.txt" is the path to our "production" data file.
        SolarPanelFileRepository repository = new SolarPanelFileRepository("./data/solarfarm.txt");
        // repository satisfies the SolarPanelRepository dependency.
        SolarPanelService service = new SolarPanelService(repository);

        ConsoleIO io = new ConsoleIO();
        // io satisfies the TextIO dependency.
        View view = new View(io);

        // view satisfies the View dependency
        // service satisfies the SolarPanelService dependency
        Controller controller = new Controller(view, service);

        // Run the app!
        controller.run();
    }
}
