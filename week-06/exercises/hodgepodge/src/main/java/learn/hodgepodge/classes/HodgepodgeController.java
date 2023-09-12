package learn.hodgepodge.classes;

import org.springframework.web.bind.annotation.*;

@RestController
public class HodgepodgeController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello world.";
    }

    @GetMapping("/get")
    public void doGet() {
    }

    @PostMapping("/post")
    public void doPost() {
    }

    @PutMapping("/put")
    public void doPut() {
    }

    @DeleteMapping("/delete")
    public void doDelete() {
    }


}

