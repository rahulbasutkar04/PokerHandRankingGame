package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardObjectBuilder;
import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.model.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankCountTest {

    @Test
    void shouldBeAbleToCountRanksWithValidCards() {
        // arrange
        CardObjectBuilder cardObjectBuilder = new CardObjectBuilder();
        List<Card> cards = cardObjectBuilder.getValidPairCards();
        RankCount rankCount = new RankCount();
        Map<Rank, Integer> rankCountMap = rankCount.rankCount(cards);

        // act & assert
        assertEquals(2, rankCountMap.get(Rank.ACE));
        assertEquals(1, rankCountMap.get(Rank.TWO));
        assertEquals(1, rankCountMap.get(Rank.THREE));
        assertEquals(1, rankCountMap.get(Rank.FOUR));
        assertEquals(null, rankCountMap.get(Rank.FIVE));
        assertEquals(null, rankCountMap.get(Rank.SIX));
        assertEquals(null, rankCountMap.get(Rank.SEVEN));
        assertEquals(null, rankCountMap.get(Rank.EIGHT));
        assertEquals(null, rankCountMap.get(Rank.NINE));
        assertEquals(null, rankCountMap.get(Rank.TEN));
        assertEquals(null, rankCountMap.get(Rank.JACK));
        assertEquals(null, rankCountMap.get(Rank.QUEEN));
        assertEquals(null, rankCountMap.get(Rank.KING));
    }

}