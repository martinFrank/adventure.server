package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.github.martinfrank.games.llmquestgenerator.action.SkillAction;

import java.util.List;

public record SkillActionDto(String actionId, String skillName ) {


    public static List<SkillActionDto> fromModels(List<SkillAction> actions) {
        return actions.stream().map(SkillActionDto::fromModel).toList();
    }

    public static SkillActionDto fromModel(SkillAction action) {
        return new SkillActionDto(action.actionId, action.skillName);
    }
}
