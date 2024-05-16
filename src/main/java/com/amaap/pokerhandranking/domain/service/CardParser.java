package com.amaap.pokerhandranking.domain.service;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.model.Rank;
import com.amaap.pokerhandranking.domain.model.Suit;
import com.amaap.pokerhandranking.domain.service.exception.InvalidCardTypeException;
import com.amaap.pokerhandranking.service.exception.InvalidCardCountException;

import java.util.List;

public class CardParser {
    public boolean validateCards(List<String> cards) throws InvalidCardCountException, InvalidCardTypeException {
        for (String cardString : cards) {
            try {
                parseCard(cardString);
            } catch (InvalidCardTypeException | InvalidCardCountException e) {
                throw  e;
            }
        }
        return true;
    }

    public Card parseCard(String cardString) throws InvalidCardCountException, InvalidCardTypeException {
        if (cardString == null || cardString.length() < 2) {
            throw new InvalidCardCountException("Invalid card string: " + cardString);
        }

        String suitKeyword = cardString.substring(0, 1);
        String rankKeyword = cardString.substring(1);

        Suit suit = Suit.fromKeyword(suitKeyword);
        Rank rank = Rank.fromKeyword(rankKeyword);

        if (suit == null || rank == null) {
            throw new InvalidCardTypeException("Invalid card Type: " + cardString);
        }

        return new Card(suit, rank);
    }
}
