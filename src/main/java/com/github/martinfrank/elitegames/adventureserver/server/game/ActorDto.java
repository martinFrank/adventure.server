package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.github.martinfrank.games.llmquestgenerator.actor.Actor;
import com.github.martinfrank.games.llmquestgenerator.actor.ActorType;
import com.github.martinfrank.games.llmquestgenerator.location.Location;

import java.util.List;

public record ActorDto(String type, String id, String description) {


    public static List<ActorDto> fromModels(List<Actor> actors) {
        return actors.stream().map(ActorDto::fromModel).toList();
    }

    private static ActorDto fromModel(Actor actor) {
        return new ActorDto(
                actor.type.toString(),
                actor.id,
                actor.description
        );
    }
}
