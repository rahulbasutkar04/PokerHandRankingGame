package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.List;
import java.util.stream.Collectors;

public class Straight implements HandRanking {
    @Override
    public boolean evaluate(List<Card> hand) {
        List<Integer> ranks = hand.stream()
                                  .map(card -> card.getRank().ordinal())
                                  .sorted()
                                  .collect(Collectors.toList());
        for (int i = 1; i < ranks.size(); i++) {
            if (ranks.get(i) != ranks.get(i - 1) + 1) {
                return false;
            }
        }
        return true;
    }
}
