package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardObjectBuilder;
import com.amaap.pokerhandranking.domain.model.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeOfKindTest {

    private final ThreeOfKind threeOfKindEvaluator = new ThreeOfKind();
    private final CardObjectBuilder cardObjectBuilder = new CardObjectBuilder();

    @Test
    void shouldBeAbleToDetectValidThreeOfKind() {
        // arrange
        List<Card> threeOfKindHand = cardObjectBuilder.getValidThreeOfKindCards();

        // act
        boolean isThreeOfKind = threeOfKindEvaluator.evaluate(threeOfKindHand);

        // assert
        assertTrue(isThreeOfKind);
    }

    @Test
    void shouldNotDetectInvalidThreeOfKind() {
        // arrange
        List<Card> nonThreeOfKindHand = cardObjectBuilder.getInValidThreeOfKindCards();

        // act
        boolean isThreeOfKind = threeOfKindEvaluator.evaluate(nonThreeOfKindHand);

        // assert
        assertFalse(isThreeOfKind);
    }
}
