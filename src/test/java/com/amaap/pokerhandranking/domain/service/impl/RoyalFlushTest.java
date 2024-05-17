package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardObjectBuilder;
import com.amaap.pokerhandranking.domain.model.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoyalFlushTest {
    CardObjectBuilder cardObjectBuilder = new CardObjectBuilder();

    @Test
    void shouldBeAbleToDetectRoyalFlush() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> royalFlushHand = cardObjectBuilder.getValidRoyalFlushCards();

        // act
        boolean isRoyalFlush = royalFlush.evaluate(royalFlushHand);

        // assert
        assertTrue(isRoyalFlush);
    }

    @Test
    void shouldNotBeAbleToDetectRoyalFlush() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> royalFlushHand = cardObjectBuilder.getInValidRoyalFlushCards();

        // act
        boolean isRoyalFlush = royalFlush.evaluate(royalFlushHand);

        // assert
        assertFalse(isRoyalFlush);
    }


}