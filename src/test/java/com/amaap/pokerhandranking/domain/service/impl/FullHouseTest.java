package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardObjectBuilder;
import com.amaap.pokerhandranking.domain.model.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FullHouseTest {
    private final FullHouse fullHouse = new FullHouse();
    private final CardObjectBuilder cardObjectBuilder = new CardObjectBuilder();

    @Test
    void shouldBeAbleToReturnTrueIfCardIsFullHouse() {
        // arrange
        List<Card> hand = cardObjectBuilder.getFullHouseCards();

        // act
        boolean result = fullHouse.evaluate(hand);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseIfCardTypeIfNotFullHouse() {
        // arrange
        List<Card> hand = cardObjectBuilder.getValidFlushCards();

        // act
        boolean result = fullHouse.evaluate(hand);

        // assert
        assertFalse(result);
    }
}
