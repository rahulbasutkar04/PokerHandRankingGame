package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FullHouseTest {
    private final FullHouse fullHouse = new FullHouse();
    private final CardRankBuilder cardRankBuilder = new CardRankBuilder();

    @Test
    void shouldBeAbleToReturnTrueIfCardIsFullHouse() {
        // arrange
        List<Card> hand = cardRankBuilder.getFullHouseCards();

        // act
        boolean result = fullHouse.evaluate(hand);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseIfCardTypeIfNotFullHouse() {
        // arrange
        List<Card> hand = cardRankBuilder.getValidFlushCards();

        // act
        boolean result = fullHouse.evaluate(hand);

        // assert
        assertFalse(result);
    }
}
