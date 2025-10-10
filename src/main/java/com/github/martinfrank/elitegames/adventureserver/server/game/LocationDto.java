package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.github.martinfrank.games.llmquestgenerator.location.Location;

import java.util.ArrayList;
import java.util.List;

public record LocationDto(String type, String id, String generation, List<String> toLocationIds) {

    public static LocationDto fromModel(Location location){
        return new LocationDto(
                location.type.toString(),
                location.id,
                location.generation,
                new ArrayList<>(location.toLocationIds));
    }
}
