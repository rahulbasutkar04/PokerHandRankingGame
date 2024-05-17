package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardObjectBuilder;
import com.amaap.pokerhandranking.domain.model.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoPairTest {

    private TwoPair twoPair;
    private CardObjectBuilder cardObjectBuilder;

    @BeforeEach
    void setUp() {
        twoPair = new TwoPair();
        cardObjectBuilder = new CardObjectBuilder();
    }

    @Test
    void shouldBeAbleToIdentifyValidTwoPair() {
        List<Card> validTwoPair = cardObjectBuilder.getValidTwoPairCards();
        assertTrue(twoPair.evaluate(validTwoPair));
    }

    @Test
    void shouldBeAbleToIdentifyInvalidTwoPair() {
        List<Card> invalidTwoPair = cardObjectBuilder.getInvalidTwoPairCards();
        assertFalse(twoPair.evaluate(invalidTwoPair));
    }
}
