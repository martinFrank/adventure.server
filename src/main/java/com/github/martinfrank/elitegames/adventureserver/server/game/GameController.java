package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.github.martinfrank.games.llmquestgenerator.actor.Actor;
import com.github.martinfrank.games.llmquestgenerator.location.Location;
import com.github.martinfrank.games.llmquestgenerator.quest.Quest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/current-location")
    public LocationDto getCurrentLocation() {
        LOGGER.debug("returning current location");
        return LocationDto.fromModel(gameService.getGame().getCurrentLocation());
    }

    @GetMapping("/current-actors")
    public List<ActorDto> getCurrentLocationActors() {
        LOGGER.debug("returning current location actors");
        Location currentLocation = gameService.getGame().getCurrentLocation();
        List<Actor> actors = gameService.getGame().getActorsAt(currentLocation);
        return ActorDto.fromModels(actors);
    }

    @GetMapping("/current-quests")
    public List<QuestDto> getCurrentQuests() {
        LOGGER.debug("returning current Quests");
        List<Quest> quests = gameService.getGame().getCurrentQuests();
        LOGGER.debug("quests.size={}", quests.size());
        return QuestDto.fromModels(quests);
    }
}