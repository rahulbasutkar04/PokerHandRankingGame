package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.List;

public class HighCard implements HandRanking {
    private  Card card;
    @Override
    public boolean evaluate(List<Card> hand) {
        Card highestCard = hand.get(0);
        for (int i = 1; i < hand.size(); i++) {
            Card currentCard = hand.get(i);
            if (currentCard.getRank().compareTo(highestCard.getRank()) > 0) {
                highestCard = currentCard;
            }
        }

        return true;
    }

    public Card getHighestCard(List<Card> cardList) {
        Card highestCard = cardList.get(0);
        for (int i = 1; i < cardList.size(); i++) {
            Card currentCard = cardList.get(i);
            if (currentCard.getRank().compareTo(highestCard.getRank()) > 0) {
                highestCard = currentCard;
            }
        }
        return highestCard;
    }

    public Card getCard() {
        return card;
    }
}
