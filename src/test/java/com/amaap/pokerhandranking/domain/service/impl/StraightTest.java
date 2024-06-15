package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightTest {

    private final Straight straightEvaluator = new Straight();
    private final CardRankBuilder cardRankBuilder = new CardRankBuilder();

    @Test
    void shouldBeAbleToDetectValidStraight() {
        // arrange
        List<Card> straightHand = cardRankBuilder.getValidStraightCards();

        // act
        boolean isStraight = straightEvaluator.evaluate(straightHand);

        // assert
        assertTrue(isStraight);
    }

    @Test
    void shouldNotDetectInvalidStraight() {
        // arrange
        List<Card> nonStraightHand = cardRankBuilder.getInValidStraightCards();

        // act
        boolean isStraight = straightEvaluator.evaluate(nonStraightHand);

        // assert
        assertFalse(isStraight);
    }
}
