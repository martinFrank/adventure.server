package com.github.martinfrank.elitegames.adventureserver.server;

import com.github.martinfrank.games.llmquestgenerator.player.Player;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerClass;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerGenerator;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerRace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testPlayer(){
        Player player = PlayerGenerator.generatePlayer("testee", PlayerClass.BARD, PlayerRace.ELF);

        Assertions.assertNotNull(player);
    }

}
