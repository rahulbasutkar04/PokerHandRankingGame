package com.amaap.pokerhandranking.domain.service;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.model.Rank;
import com.amaap.pokerhandranking.domain.model.Suit;
import com.amaap.pokerhandranking.domain.service.exception.InvalidCardNameException;

import java.util.ArrayList;
import java.util.List;

public class CardConvertor {

    public List<Card> convertToCardList(List<String> hand) throws InvalidCardNameException {
        List<Card> cards = new ArrayList<>();
        for (String cardStr : hand) {
            if (cardStr.length() != 2) {
                throw new InvalidCardNameException("Invalid card string: " + cardStr);
            }
            String suitStr = cardStr.substring(0, 1);
            String rankStr = cardStr.substring(1);

            Suit suit = Suit.fromKeyword(suitStr);
            Rank rank = Rank.fromKeyword(rankStr);

            if (suit == null || rank == null) {
                throw new InvalidCardNameException("Invalid card string: " + cardStr);
            }

            cards.add(new Card(suit, rank));
        }
        return cards;
    }
}
