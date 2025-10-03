package com.github.martinfrank.elitegames.adventureserver.server;

import com.github.martinfrank.games.llmquestgenerator.adventure.Adventure;
import com.github.martinfrank.games.llmquestgenerator.adventure.AdventureSerializer;
import com.github.martinfrank.games.llmquestgenerator.adventure.SimpleAdventureGenerator;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    private static final Logger LOGGER = LogManager.getLogger(GameTest.class);

    @Test
    void testGenerationGame() {
        SimpleAdventureGenerator gameGenerator = new SimpleAdventureGenerator();
        Adventure adventure = gameGenerator.generate();
        LOGGER.debug(new Gson().toJson(adventure));
        Assertions.assertNotNull(adventure);
        Assertions.assertNotNull(adventure.locations);
        Assertions.assertFalse(adventure.locations.isEmpty());
        Assertions.assertNotNull(adventure.actors);
        Assertions.assertFalse(adventure.actors.isEmpty());
        Assertions.assertNotNull(adventure.quests);
        Assertions.assertFalse(adventure.quests.isEmpty());
        Assertions.assertNotNull(adventure.changes);
        Assertions.assertFalse(adventure.changes.isEmpty());
    }

    @Test
    void serializeTest() {
        SimpleAdventureGenerator gameGenerator = new SimpleAdventureGenerator();
        Adventure generated = gameGenerator.generate();
        String generatedJson = new Gson().toJson(generated);

        Adventure loaded = AdventureSerializer.fromJson(generatedJson);
        String loadedJson = new Gson().toJson(loaded);
        Assertions.assertEquals(generatedJson, loadedJson);
    }


}
