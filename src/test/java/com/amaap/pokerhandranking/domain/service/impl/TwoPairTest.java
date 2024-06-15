package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoPairTest {

    private TwoPair twoPair;
    private CardRankBuilder cardRankBuilder;

    @BeforeEach
    void setUp() {
        twoPair = new TwoPair();
        cardRankBuilder = new CardRankBuilder();
    }

    @Test
    void shouldBeAbleToIdentifyValidTwoPair() {
        List<Card> validTwoPair = cardRankBuilder.getValidTwoPairCards();
        assertTrue(twoPair.evaluate(validTwoPair));
    }

    @Test
    void shouldBeAbleToIdentifyInvalidTwoPair() {
        List<Card> invalidTwoPair = cardRankBuilder.getInvalidTwoPairCards();
        assertFalse(twoPair.evaluate(invalidTwoPair));
    }
}
