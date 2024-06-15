package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.builder.CardRankBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import com.amaap.pokerhandranking.domain.model.valueobject.Rank;
import com.amaap.pokerhandranking.domain.model.valueobject.Suit;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoyalFlushTest {
    CardRankBuilder cardRankBuilder = new CardRankBuilder();

    @Test
    void shouldBeAbleToDetectRoyalFlush() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> royalFlushHand = cardRankBuilder.getValidRoyalFlushCards();

        // act
        boolean isRoyalFlush = royalFlush.evaluate(royalFlushHand);

        // assert
        assertTrue(isRoyalFlush);
    }

    @Test
    void shouldNotBeAbleToDetectRoyalFlush() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> invalidRoyalFlushHand = cardRankBuilder.getInValidRoyalFlushCards();

        // act
        boolean isRoyalFlush = royalFlush.evaluate(invalidRoyalFlushHand);

        // assert
        assertFalse(isRoyalFlush);
    }

    @Test
    void shouldNotDetectRoyalFlushIfNotAllCardsAreSameSuit() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> mixedSuitHand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.TEN),
                new Card(Suit.HEARTS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.KING),
                new Card(Suit.SPADES, Rank.ACE)  // Different suit
        );

        // act
        boolean isRoyalFlush = royalFlush.evaluate(mixedSuitHand);

        // assert
        assertFalse(isRoyalFlush);
    }

    @Test
    void shouldNotDetectRoyalFlushIfOneCardIsMissing() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> missingCardHand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.TEN),
                new Card(Suit.HEARTS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.KING)
                // Missing ACE
        );

        // act
        boolean isRoyalFlush = royalFlush.evaluate(missingCardHand);

        // assert
        assertFalse(isRoyalFlush);
    }

    @Test
    void shouldNotDetectRoyalFlushIfExtraCardIsPresent() {
        // arrange
        RoyalFlush royalFlush = new RoyalFlush();
        List<Card> extraCardHand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.TEN),
                new Card(Suit.HEARTS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.KING),
                new Card(Suit.HEARTS, Rank.ACE)
        );

        // act
        boolean isRoyalFlush = royalFlush.evaluate(extraCardHand);

        // assert
        assertTrue(isRoyalFlush);
    }


}
