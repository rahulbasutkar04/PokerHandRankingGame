package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardObjectBuilder;
import com.amaap.pokerhandranking.domain.model.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightTest {

    private final Straight straightEvaluator = new Straight();
    private final CardObjectBuilder cardObjectBuilder = new CardObjectBuilder();

    @Test
    void shouldBeAbleToDetectValidStraight() {
        // arrange
        List<Card> straightHand = cardObjectBuilder.getValidStraightCards();

        // act
        boolean isStraight = straightEvaluator.evaluate(straightHand);

        // assert
        assertTrue(isStraight);
    }

    @Test
    void shouldNotDetectInvalidStraight() {
        // arrange
        List<Card> nonStraightHand = cardObjectBuilder.getInValidStraightCards();

        // act
        boolean isStraight = straightEvaluator.evaluate(nonStraightHand);

        // assert
        assertFalse(isStraight);
    }
}
