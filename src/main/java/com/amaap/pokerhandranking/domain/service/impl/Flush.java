package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.model.Suit;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flush implements HandRanking {
    @Override
    public boolean evaluate(List<Card> hand) {
        Map<Suit, Integer> suitCount = new HashMap<>();
        for (Card card : hand) {
            Suit suit = card.getSuit();
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        return suitCount.containsValue(5);
    }
}
