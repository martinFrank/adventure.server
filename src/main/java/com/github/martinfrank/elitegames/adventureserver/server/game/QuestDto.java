package com.github.martinfrank.elitegames.adventureserver.server.game;

import com.github.martinfrank.games.llmquestgenerator.quest.Quest;

import java.util.List;

public record QuestDto(String id,
                       List<String> prerequisiteQuestIds,
                       List<String> taskIds,
                       String plot,
                       String parentId,
                       boolean isCompleted) {
    public static List<QuestDto> fromModels(List<Quest> quests) {
        return quests.stream().map(QuestDto::fromModel).toList();
    }

    private static QuestDto fromModel(Quest quest) {
        return new QuestDto(
                quest.id,
                quest.prerequisiteQuestIds,
                quest.taskIds,
                quest.plot,
                quest.parentId,
                quest.isCompleted
                );
    }
}
