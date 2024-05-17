package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.model.Rank;
import com.amaap.pokerhandranking.domain.model.Suit;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.List;

public class RoyalFlush implements HandRanking {
    @Override
    public boolean evaluate(List<Card> hand) {

        Suit firstSuit = hand.get(0).getSuit();
        boolean sameSuit = hand.stream().allMatch(card -> card.getSuit() == firstSuit);
        if (!sameSuit) {
            return false;
        }
        boolean containsTen = false, containsJack = false, containsQueen = false, containsKing = false, containsAce = false;
        for (Card card : hand) {
            Rank rank = card.getRank();
            switch (rank) {
                case TEN:
                    containsTen = true;
                    break;
                case JACK:
                    containsJack = true;
                    break;
                case QUEEN:
                    containsQueen = true;
                    break;
                case KING:
                    containsKing = true;
                    break;
                case ACE:
                    containsAce = true;
                    break;
            }
        }

        return containsTen && containsJack && containsQueen && containsKing && containsAce;
    }

}
