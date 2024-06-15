package com.amaap.pokerhandranking.domain.service;

import com.amaap.pokerhandranking.domain.model.entity.Card;
import com.amaap.pokerhandranking.domain.model.valueobject.Rank;
import com.amaap.pokerhandranking.domain.model.valueobject.Suit;
import com.amaap.pokerhandranking.domain.service.exception.InvalidCardNameException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardConvertorTest {

    @Test
    void shouldBeAbleToConvertToCardListSuccessfully() throws InvalidCardNameException {
        // arrange
        CardConvertor cardConvertor = new CardConvertor();
        List<String> hand = List.of("S2", "D5", "C7", "ST", "HA");

        // act
        List<Card> cards = cardConvertor.convertToCardList(hand);

        // assert
        assertEquals(5, cards.size());
        assertEquals(Suit.SPADES, cards.get(0).getSuit());
        assertEquals(Rank.TWO, cards.get(0).getRank());
    }

    @Test
    void shouldThrowExceptionForInvalidCardString() {
        // arrange
        CardConvertor cardConvertor = new CardConvertor();
        List<String> hand = List.of("S2", "D5", "C7", "T", "HA");

        // act & assert
        assertThrows(InvalidCardNameException.class, () -> cardConvertor.convertToCardList(hand));
    }

    @Test
    void shouldThrowExceptionForInvalidRank() {
        // arrange
        CardConvertor cardConvertor = new CardConvertor();
        List<String> hand = List.of("S2", "D5", "C7", "ST", "HX");

        // act & assert
        assertThrows(InvalidCardNameException.class, () -> cardConvertor.convertToCardList(hand));
    }

}
