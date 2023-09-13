package learn.hodgepodge.classes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class HodgepodgeController {


    // TODO: add response entities

    // Sheep variables and methods

    private int sheepCount;

    public int getSheepCount() {
        return sheepCount;
    }

    public void setSheepCount(int sheepCount) {
        this.sheepCount = sheepCount;
    }

    // To do variables and methods

    public static ArrayList<String> todos = new ArrayList<>();

    // BASIC

    @GetMapping("/")
    public String helloWorld() {
        return "Hello world.";
    }

    @GetMapping("/name")
    public String getMyName() {
        return "Andrew";
    }

    @GetMapping("/current/time")
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

    @GetMapping("/greet/{name}")
    public String getGreeting(@PathVariable String name) {
        return String.format("Hello, %s", name);
    }

    // SHEEP

    @PutMapping("/sheep")
    public void countSheep() {
        setSheepCount(sheepCount + 1);
    }

    @GetMapping("/sheep")
    public int getSheep() {
        return getSheepCount();
    }

    @PutMapping("/sheep/{amount}")
    public void increaseSheep(@PathVariable int amount) {
        setSheepCount(sheepCount + amount);
    }

    @PostMapping("/sheep")
    public void increaseSheepWithObject(@RequestBody SheepValue value) {
        setSheepCount(sheepCount + value.getAmount());
    }

    @DeleteMapping("/sheep")
    public void lostSheep() {
        setSheepCount(sheepCount - 1);
    }

    // TO DO

    @GetMapping("/todo")
    public ArrayList<String> getTodo() {
        return todos;
    }

//    Return the list.
//    HTTP Method: GET
//    Path: /todo
//    Input: None
//    Output: To-Dos as List<String>


    // , @RequestParam("appendList") String header
    @PutMapping("/todo")
    public void appendList(@RequestBody ArrayList<String> items) {
        if (todos != null) {
            todos.addAll(items);
        }
    }

//    Append a list of To-Dos to todos.
//    HTTP Method: PUT
//    Path: /todo
//    Input: @RequestBody List<String> items
//    Output: None

    @PutMapping("/todo/{item}")
    public void appendListToTodo(@PathVariable String item) {
        todos.add(item);
    }

//    Add one To-Do to todos.
//    HTTP Method: PUT
//    Path: /todo/{item}
//    Input: @PathVariable String item
//    Output: None

    @DeleteMapping("/todo/{index}")
    public ResponseEntity<String> deleteTodo(@PathVariable int index) {

        if (todos.isEmpty()) {
            return new ResponseEntity<>(String.format("Cannot find value at index %s", index), HttpStatus.NOT_FOUND);
        }

        todos.remove(index);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    Remove the To-Do at the specified index. If it doesn't exist, return 404 Not Found. Otherwise, return 200 OK.
//    HTTP Method: DELETE
//    Path: /todo/{index}
//    Input: @PathVariable int index
//    Output: None

    // , @RequestParam("replaceTodo") String header
    @PostMapping("/todo")
    public void replaceTodo(@RequestBody ArrayList<String> items) {
        todos = items;
    }

//    Replace the current todos with the list provided.
//    HTTP Method: POST
//    Path: /todo
//    Input: @RequestBody
//    List<String> items
//    Output: None

}

