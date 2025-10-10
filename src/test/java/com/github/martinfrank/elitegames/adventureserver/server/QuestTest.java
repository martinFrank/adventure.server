package com.github.martinfrank.elitegames.adventureserver.server;

import com.github.martinfrank.games.llmquestgenerator.adventure.Adventure;
import com.github.martinfrank.games.llmquestgenerator.adventure.SimpleAdventureGenerator;
import com.github.martinfrank.games.llmquestgenerator.game.Game;
import com.github.martinfrank.games.llmquestgenerator.player.Player;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerClass;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerGenerator;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerRace;
import com.github.martinfrank.games.llmquestgenerator.quest.Quest;
import org.junit.jupiter.api.Test;

import java.util.List;

class QuestTest {

    @Test
    void testGenerationGame() {
        SimpleAdventureGenerator gameGenerator = new SimpleAdventureGenerator();
        Adventure adventure = gameGenerator.generate();
        Player player = PlayerGenerator.generatePlayer("testee", PlayerClass.BARD, PlayerRace.ELF);
        player.currentLocationId = "MARKET_PLACE";

        Game game = new Game("testId", adventure, player);
        List<Quest> quests = game.getCurrentQuests();

        System.out.println("size="+quests.size());

    }
}
