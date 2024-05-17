package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardObjectBuilder;
import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.model.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighCardTest {
    private final HighCard highCard = new HighCard();
    private final CardObjectBuilder cardObjectBuilder = new CardObjectBuilder();

    @Test
    void shouldBeAbleToReturnHighCard() {
        // arrange
        List<Card> hand = cardObjectBuilder.getValidFlushCards();

        // act
        Card highestCard = highCard.getHighestCard(hand);

        // assert
        assertEquals(Rank.TEN, highestCard.getRank());
    }
}
