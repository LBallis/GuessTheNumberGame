package gr.ballis.controller;

import gr.ballis.service.GameService;
import gr.ballis.util.AttributeNames;
import gr.ballis.util.GameMappings;
import gr.ballis.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping(GameMappings.HOME)
    public String home(){
        return ViewNames.HOME;
    }

    @GetMapping(GameMappings.PLAY)
    public String play(Model model){
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());

        if(gameService.isGameOver()){
            gameService.reset();
            return ViewNames.GAME_OVER;
        }
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        return ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess){
        log.info("guess = {}", guess);

        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }

}


