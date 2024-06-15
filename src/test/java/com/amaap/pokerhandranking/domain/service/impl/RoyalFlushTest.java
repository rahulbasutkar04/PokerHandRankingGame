package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoyalFlushTest {
    CardRankBuilder cardRankBuilder = new CardRankBuilder();

    @Test
    void shouldBeAbleToDetectRoyalFlush() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> royalFlushHand = cardRankBuilder.getValidRoyalFlushCards();

        // act
        boolean isRoyalFlush = royalFlush.evaluate(royalFlushHand);

        // assert
        assertTrue(isRoyalFlush);
    }

    @Test
    void shouldNotBeAbleToDetectRoyalFlush() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> royalFlushHand = cardRankBuilder.getInValidRoyalFlushCards();

        // act
        boolean isRoyalFlush = royalFlush.evaluate(royalFlushHand);

        // assert
        assertFalse(isRoyalFlush);
    }


}