package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.github.martinfrank.games.llmquestgenerator.location.Location;
import com.github.martinfrank.games.llmquestgenerator.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);
    private GameService gameService;

    public PlayerController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/player")
    public PlayerDto getPlayer() {
        Player player = gameService.getGame().getPlayer();
        LOGGER.debug("returning player with class: {} and race: {}", player.playerClass, player.playerRace);
        return PlayerDto.fromModel(player);
    }

    @PostMapping("/destination")
    public PlayerDto moveToDestination(@RequestBody DestinationRequestDto destinationRequest) {
        LOGGER.debug("try moving player to {}", destinationRequest.locationId());
        //{"locationId":"ELDER_HUT"}
        List<Location> possibleDestinations = gameService.getGame().getDestinations();
        boolean isValid = possibleDestinations.stream().anyMatch(l -> Objects.equals(l.id, destinationRequest.locationId()));
        if (isValid){
            gameService.getGame().getPlayer().currentLocationId = destinationRequest.locationId();
            return PlayerDto.fromModel(gameService.getGame().getPlayer());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find location");
    }
}