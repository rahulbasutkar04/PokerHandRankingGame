package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import com.amaap.pokerhandranking.domain.service.HandRanking;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FourOfKindTest {

    CardRankBuilder cardRankBuilder = new CardRankBuilder();

    @Test
    void shouldBeAbleToReturnTrueIfCardIsFourOfKind() {
        // arrange
        List<Card> hand = cardRankBuilder.getValidThreeOfKindCard();
        HandRanking fourOfKind = new FourOfKind();

        // act & assert
        assertTrue(fourOfKind.evaluate(hand));
    }

    @Test
    void shouldBeAbleToReturnFalseIfCardIsFourOfKind() {
        // arrange
        List<Card> hand = cardRankBuilder.getInValidThreeOfKindCard();
        HandRanking fourOfKind = new FourOfKind();

        // act & assert
        assertFalse(fourOfKind.evaluate(hand));
    }
}
