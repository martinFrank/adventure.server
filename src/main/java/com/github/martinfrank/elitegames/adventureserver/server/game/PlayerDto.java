package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.github.martinfrank.games.llmquestgenerator.player.Player;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerClass;
import com.github.martinfrank.games.llmquestgenerator.player.PlayerRace;

public record PlayerDto(String name,
                        String playerClass,
                        String playerRace,
                        String currentLocationId) {

    public static PlayerDto fromModel(Player player) {
        return new PlayerDto(
                player.name,
                player.playerClass.toString(),
                player.playerRace.toString(),
                player.currentLocationId);
    }
}
