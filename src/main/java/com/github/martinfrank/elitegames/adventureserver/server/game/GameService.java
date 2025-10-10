package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.github.martinfrank.games.llmquestgenerator.adventure.Adventure;
import com.github.martinfrank.games.llmquestgenerator.adventure.SimpleAdventureGenerator;
import com.github.martinfrank.games.llmquestgenerator.game.Game;
import com.github.martinfrank.games.llmquestgenerator.player.Player;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerClass;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerGenerator;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerRace;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private Game game;

    public GameService(){
        Player player = PlayerGenerator.generatePlayer("martin", PlayerClass.BARD, PlayerRace.ELF);
        SimpleAdventureGenerator adventureGenerator = new SimpleAdventureGenerator();
        Adventure adventure = adventureGenerator.generate();
        game = new Game("gameId", adventure, player);
    }

    public Game getGame(){
        return game;
    }

}
