package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.fasterxml.jackson.databind.ObjectMapper;
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
@RequestMapping("/api/game")
public class GameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    @GetMapping("/adventure")
    public Map<String, Object> getAdventure() {
        LOGGER.debug("generation random game");

        try {
            ClassPathResource resource = new ClassPathResource("game.json");
            ObjectMapper objectMapper = new ObjectMapper();

            try (InputStream inputStream = resource.getInputStream()) {
                @SuppressWarnings("unchecked")
                Map<String, Object> gameData = objectMapper.readValue(inputStream, Map.class);

                LOGGER.debug("Successfully loaded adventure from game.json with {} locations, {} actors, {} quests",
                        gameData.get("locations") != null ? ((List<?>) gameData.get("locations")).size() : 0,
                        gameData.get("actors") != null ? ((List<?>) gameData.get("actors")).size() : 0,
                        gameData.get("quests") != null ? ((List<?>) gameData.get("quests")).size() : 0);

                return gameData;
            }
        } catch (IOException e) {
            LOGGER.error("Error loading game.json file", e);
            throw new RuntimeException("Failed to load game data from file", e);
        }
    }
}