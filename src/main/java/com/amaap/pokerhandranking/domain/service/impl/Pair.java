package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.model.Rank;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.List;
import java.util.Map;

public class Pair implements HandRanking {
    @Override
    public boolean evaluate(List<Card> hand) {
        RankCount rc=new RankCount();
        return hasOnePair(rc.rankCount(hand));

    }
    private static boolean hasOnePair(Map<Rank, Integer> rankCount) {
        return rankCount.containsValue(2);
    }
}
