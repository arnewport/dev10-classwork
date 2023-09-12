package learn.hodgepodge.classes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Random;

@RestController
@RequestMapping("/")
public class GameController {

    private int numberToBeGuessed;
    private final int boundary = 5;

    public int getNumberToBeGuessed() {
        return numberToBeGuessed;
    }

    public void setNumberToBeGuessed(int numberToBeGuessed) {
        this.numberToBeGuessed = numberToBeGuessed;
    }

    public void createRandomNumber() {
        Random random = new Random();
        setNumberToBeGuessed(random.nextInt(boundary) + 1);
    }

    @PostMapping("/guess")
    public ResponseEntity<?> startGame() {
        createRandomNumber();
        return new ResponseEntity<>("A random number has been picked!", HttpStatus.OK);
    }

    @PutMapping("/guess")
    public ResponseEntity<?> enterGuess(@RequestBody Number guess) {
        if (guess.getNumber() > boundary) {
            return new ResponseEntity<>(String.format("The number you picked is higher than %s. Pick a number between 1 and %s.", boundary, boundary), HttpStatus.OK);
        }
        if (guess.getNumber() < 1) {
            return new ResponseEntity<>(String.format("The number you picked is lower than 1. Pick a number between 1 and %s.", boundary), HttpStatus.OK);
        }
        if (guess.getNumber() > numberToBeGuessed) {
            return new ResponseEntity<>(String.format("You guessed %s. Your guess is higher than the number to be guessed. Try again!", guess.getNumber()) , HttpStatus.OK);
        }
        if (guess.getNumber() < numberToBeGuessed) {
            return new ResponseEntity<>(String.format("You guessed %s. Your guess is less than the number to be guessed. Try again!", guess.getNumber()), HttpStatus.OK);
        }
        if (guess.getNumber() == numberToBeGuessed) {
            return new ResponseEntity<>("You correctly guessed the number! Congratulations, you win!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Something weird happened!", HttpStatus.OK);
    }

}
