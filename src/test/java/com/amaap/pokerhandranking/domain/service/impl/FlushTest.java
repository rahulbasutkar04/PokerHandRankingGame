package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardObjectBuilder;
import com.amaap.pokerhandranking.domain.model.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlushTest {
    CardObjectBuilder cardObjectBuilder = new CardObjectBuilder();

    @Test
    void shouldBeAbleToReturnTrueForFlush() {
        // arrange
        Flush flush = new Flush();
        List<Card> hand = cardObjectBuilder.getValidFlushCards();

        // act
        boolean result = flush.evaluate(hand);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseForNonFlush() {
        // arrange
        Flush flush = new Flush();
        List<Card> hand = cardObjectBuilder.getInValidFlushCards();

        // act
        boolean result = flush.evaluate(hand);

        // assert
        assertFalse(result);
    }
}
