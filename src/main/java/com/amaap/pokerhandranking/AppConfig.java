package com.amaap.pokerhandranking;

import com.amaap.pokerhandranking.controller.HandController;
import com.amaap.pokerhandranking.controller.RankController;
import com.amaap.pokerhandranking.domain.service.CardParser;
import com.amaap.pokerhandranking.repository.HandRepository;
import com.amaap.pokerhandranking.repository.impl.InMemoryHandRepository;
import com.amaap.pokerhandranking.service.HandService;

public class AppConfig {
    public HandController handController() {
        HandService handService = handService();
        return new HandController(handService);
    }

    public RankController rankController() {
        return new RankController();
    }

    private HandService handService() {
        CardParser cardParser = new CardParser();
        HandRepository handRepository = InMemoryHandRepository.getInstance();
        return new HandService(cardParser, (InMemoryHandRepository) handRepository);
    }
}
