package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlushTest {
    CardRankBuilder cardRankBuilder = new CardRankBuilder();

    @Test
    void shouldBeAbleToReturnTrueForFlush() {
        // arrange
        Flush flush = new Flush();
        List<Card> hand = cardRankBuilder.getValidFlushCards();

        // act
        boolean result = flush.evaluate(hand);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseForNonFlush() {
        // arrange
        Flush flush = new Flush();
        List<Card> hand = cardRankBuilder.getInValidFlushCards();

        // act
        boolean result = flush.evaluate(hand);

        // assert
        assertFalse(result);
    }
}
