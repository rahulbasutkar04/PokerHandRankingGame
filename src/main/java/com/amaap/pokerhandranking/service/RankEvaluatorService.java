package com.amaap.pokerhandranking.service;

import com.amaap.pokerhandranking.domain.service.HandEvaluator;
import com.amaap.pokerhandranking.repository.impl.InMemoryHandRepository;
import com.amaap.pokerhandranking.service.exception.CardsNotFoundException;

import java.util.List;

public class RankEvaluatorService {
    private InMemoryHandRepository inMemoryHandRepository;
    private HandEvaluator handEvaluator;

    String HandRank;

    public RankEvaluatorService(InMemoryHandRepository inMemoryHandRepository, HandEvaluator handEvaluator) {
        this.inMemoryHandRepository = inMemoryHandRepository;
        this.handEvaluator = handEvaluator;
    }

    public void getRank() throws CardsNotFoundException {
        List<String> hand = inMemoryHandRepository.getCards();
        if (hand.size() == 0) throw new CardsNotFoundException("No Cards Found");
        else {
            HandRank = handEvaluator.evaluate(hand);
        }
    }


    public String getHandRank() {
        return HandRank;
    }
}
