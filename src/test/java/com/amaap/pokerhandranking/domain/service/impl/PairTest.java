package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTest {
    private final Pair pair = new Pair();
    private final CardRankBuilder cardRankBuilder = new CardRankBuilder();

    @Test
    void shouldBeAbleToReturnTrueIfCardIsValidPairCard() {
        // arrange
        List<Card> hand = cardRankBuilder.getValidPairCards();

        // act
        boolean result = pair.evaluate(hand);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseIfCardIsValidPairCard() {
        // arrange
        List<Card> hand = cardRankBuilder.getInvalidPairCards();

        // act
        boolean result = pair.evaluate(hand);

        // assert
        assertFalse(result);
    }
}
