package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import com.amaap.pokerhandranking.domain.model.valueobject.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighCardTest {
    private final HighCard highCard = new HighCard();
    private final CardRankBuilder cardRankBuilder = new CardRankBuilder();

    @Test
    void shouldBeAbleToReturnHighCard() {
        // arrange
        List<Card> hand = cardRankBuilder.getValidFlushCards();

        // act
        Card highestCard = highCard.getHighestCard(hand);

        // assert
        assertEquals(Rank.TEN, highestCard.getRank());
    }
}
