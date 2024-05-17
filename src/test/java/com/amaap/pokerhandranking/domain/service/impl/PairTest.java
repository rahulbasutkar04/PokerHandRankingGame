package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardObjectBuilder;
import com.amaap.pokerhandranking.domain.model.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTest {
    private final Pair pair = new Pair();
    private final CardObjectBuilder cardObjectBuilder = new CardObjectBuilder();

    @Test
    void shouldBeAbleToReturnTrueIfCardIsValidPairCard() {
        // arrange
        List<Card> hand = cardObjectBuilder.getValidPairCards();

        // act
        boolean result = pair.evaluate(hand);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseIfCardIsValidPairCard() {
        // arrange
        List<Card> hand = cardObjectBuilder.getInvalidPairCards();

        // act
        boolean result = pair.evaluate(hand);

        // assert
        assertFalse(result);
    }
}
