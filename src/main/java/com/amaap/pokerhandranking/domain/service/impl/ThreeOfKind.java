package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.entity.Card;
import com.amaap.pokerhandranking.domain.model.valueobject.Rank;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.List;
import java.util.Map;

public class ThreeOfKind implements HandRanking {
    @Override
    public boolean evaluate(List<Card> hand) {

        RankCount rc = new RankCount();

        return hasThreeOfAKind(rc.rankCount(hand));
    }

    private static boolean hasThreeOfAKind(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(3);
    }
}
