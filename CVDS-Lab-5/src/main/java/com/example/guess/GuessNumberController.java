package com.example.guess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guess")
public class GuessNumberController {

    private final GuessNumber guessNumber;

    @Autowired
    public GuessNumberController(GuessNumber guessNumber) {
        this.guessNumber = guessNumber;
    }

    @GetMapping
    public String showGamePage(Model model) {
        model.addAttribute("prize", guessNumber.getPrize());
        return "guess";
    }

    @PostMapping
    public String playGame(@RequestParam("numero") int userGuess, Model model) {
        int randomNumber = guessNumber.generateRandomNumber();

        if (guessNumber.checkGuess(userGuess, randomNumber)) {
            model.addAttribute("message", "¡Felicidades! Ganaste $" + guessNumber.getPrize());
        } else {
            guessNumber.reducePrize();
            model.addAttribute("message", "Fallaste, sigue intentando. Tu premio actual es de $" + guessNumber.getPrize());
        }
        return "result";
    }

    @GetMapping("/reset")
    public String resetGame() {
        guessNumber.resetGame();
        return "redirect:/guess";
    }
}
