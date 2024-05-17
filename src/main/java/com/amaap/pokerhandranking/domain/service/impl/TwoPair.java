package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.model.Rank;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.List;
import java.util.Map;

public class TwoPair implements HandRanking {
    @Override
    public boolean evaluate(List<Card> hand) {
        RankCount rc = new RankCount();

        return hasTwoPair(rc.rankCount(hand));
    }

    private static boolean hasTwoPair(Map<Rank, Integer> rankCount) {
        int pairCount = 0;
        for (int count : rankCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

}