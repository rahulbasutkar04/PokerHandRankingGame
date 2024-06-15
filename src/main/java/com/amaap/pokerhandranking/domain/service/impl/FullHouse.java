package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.entity.Card;
import com.amaap.pokerhandranking.domain.model.valueobject.Rank;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.List;
import java.util.Map;

public class FullHouse implements HandRanking {
    @Override
    public boolean evaluate(List<Card> hand) {
        RankCount rc = new RankCount();
        Map<Rank, Integer> rankCount = rc.rankCount(hand);
        return hasFullHouse(rankCount);
    }
    private static boolean hasFullHouse(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(3) && rankCount.containsValue(2);
    }
}
