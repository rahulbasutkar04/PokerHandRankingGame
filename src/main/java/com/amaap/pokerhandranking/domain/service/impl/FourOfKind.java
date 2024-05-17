package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.model.Rank;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.List;
import java.util.Map;

public class FourOfKind implements HandRanking {
    @Override
    public boolean evaluate(List<Card> hand) {
        RankCount rankCounter = new RankCount();
        Map<Rank, Integer> rankCount = rankCounter.rankCount(hand);
        return rankCount.containsValue(4);
    }
}
