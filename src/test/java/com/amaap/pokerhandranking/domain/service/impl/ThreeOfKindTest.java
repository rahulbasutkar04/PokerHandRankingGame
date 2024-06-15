package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeOfKindTest {

    private final ThreeOfKind threeOfKindEvaluator = new ThreeOfKind();
    private final CardRankBuilder cardRankBuilder = new CardRankBuilder();

    @Test
    void shouldBeAbleToDetectValidThreeOfKind() {
        // arrange
        List<Card> threeOfKindHand = cardRankBuilder.getValidThreeOfKindCards();

        // act
        boolean isThreeOfKind = threeOfKindEvaluator.evaluate(threeOfKindHand);

        // assert
        assertTrue(isThreeOfKind);
    }

    @Test
    void shouldNotDetectInvalidThreeOfKind() {
        // arrange
        List<Card> nonThreeOfKindHand = cardRankBuilder.getInValidThreeOfKindCards();

        // act
        boolean isThreeOfKind = threeOfKindEvaluator.evaluate(nonThreeOfKindHand);

        // assert
        assertFalse(isThreeOfKind);
    }
}
