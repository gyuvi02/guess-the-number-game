package org.gyula.controller;

import lombok.extern.slf4j.Slf4j;
import org.gyula.service.GameService;
import org.gyula.util.AttributeNames;
import org.gyula.util.GameMappings;
import org.gyula.util.Viewnames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

    // fields
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // REQUEST methods

    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model = {}", model);

        if (gameService.isGameOver()) {
            return Viewnames.GAME_OVER;
        }
        return Viewnames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess) {
        log.info("guess = {}", guess);
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }

    @GetMapping(GameMappings.RESTART)
    public String restart(Model model) {
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        gameService.reset();
        log.info("redirected to play after reset");
        return GameMappings.REDIRECT_PLAY ;
    }
}
