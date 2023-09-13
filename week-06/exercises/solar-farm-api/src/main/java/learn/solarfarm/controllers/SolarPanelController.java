package learn.solarfarm.controllers;

import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/solar-panel")
public class SolarPanelController {

    private final SolarPanelService service;


    public SolarPanelController(SolarPanelService service) {
        this.service = service;
    }

    @GetMapping("/{section}")
    public List<SolarPanel> findBySection(@PathVariable String section) {
        return service.findBySection(section);
    }

    @PostMapping("/")
    public ResponseEntity<SolarPanelResult> add(@RequestBody SolarPanel panel) {
        SolarPanelResult result = service.create(panel);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    // TODO: ADD DEPTH AND ERROR HANDLING
    @PutMapping("/{id}")
    public ResponseEntity<SolarPanelResult> update(@RequestBody SolarPanel panel) {
        SolarPanelResult result = service.update(panel);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    // TODO: ASSURE THIS WORKS
    @DeleteMapping("/{id}")
    public ResponseEntity<SolarPanelResult> deleteById(@PathVariable int id) {
        SolarPanelResult result = service.deleteById(id);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        // Add a NOT FOUND message
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}
