package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.martinfrank.games.llmquestgenerator.player.Player;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerClass;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerGenerator;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerRace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);
    private GameService gameService;

    public PlayerController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/player")
    public Player getPlayer() {
        Player player = gameService.getGame().getPlayer();
        LOGGER.debug("returning player with class: {} and race: {}", player.playerClass, player.playerRace);
        return player;
    }
}