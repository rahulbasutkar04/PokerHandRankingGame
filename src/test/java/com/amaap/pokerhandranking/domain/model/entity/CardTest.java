package com.amaap.pokerhandranking.domain.model.entity;


import com.amaap.pokerhandranking.domain.model.valueobject.Rank;
import com.amaap.pokerhandranking.domain.model.valueobject.Suit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void shouldBeAbleToCreateCardWithSuitAndRank() {
        // arrange
        Suit suit = Suit.HEARTS;
        Rank rank = Rank.ACE;

        // act
        Card card = new Card(suit, rank);

        // assert
        assertNotNull(card);
        assertEquals(suit, card.getSuit());
        assertEquals(rank, card.getRank());
    }

    @Test
    public void shouldBeAbleToGetSuit() {
        // arrange
        Suit suit = Suit.SPADES;
        Rank rank = Rank.KING;

        // act
        Card card = new Card(suit, rank);

        // assert
        assertEquals(suit, card.getSuit());
    }

    @Test
    public void shouldBeAbleToGetRank() {
        // arrange
        Suit suit = Suit.CLUBS;
        Rank rank = Rank.QUEEN;

        // act
        Card card = new Card(suit, rank);

        // assert
        assertEquals(rank, card.getRank());
    }

    @Test
    public void shouldBeAbleToConvertToString() {
        // arrange
        Suit suit = Suit.DIAMONDS;
        Rank rank = Rank.JACK;

        // act
        Card card = new Card(suit, rank);

        // assert
        assertEquals(suit.getName() + rank.getName(), card.toString());
    }

    @Test
    public void shouldBeAbleToCheckEquality() {
        // arrange
        Suit suit1 = Suit.HEARTS;
        Rank rank1 = Rank.TEN;
        Suit suit2 = Suit.HEARTS;
        Rank rank2 = Rank.TEN;
        Suit suit3 = Suit.SPADES;
        Rank rank3 = Rank.NINE;

        // act
        Card card1 = new Card(suit1, rank1);
        Card card2 = new Card(suit2, rank2);
        Card card3 = new Card(suit3, rank3);

        // assert
        assertEquals(card1, card2);
        assertNotEquals(card1, card3);
    }

    @Test
    public void shouldBeAbleToGenerateHashCode() {
        // arrange
        Suit suit1 = Suit.HEARTS;
        Rank rank1 = Rank.TEN;
        Suit suit2 = Suit.HEARTS;
        Rank rank2 = Rank.TEN;
        Suit suit3 = Suit.SPADES;
        Rank rank3 = Rank.NINE;

        // act
        Card card1 = new Card(suit1, rank1);
        Card card2 = new Card(suit2, rank2);
        Card card3 = new Card(suit3, rank3);

        // assert
        assertEquals(card1.hashCode(), card2.hashCode());
        assertNotEquals(card1.hashCode(), card3.hashCode());
    }

    @Test
    public void shouldBeAbleToGetRankFromKeyword() {
        assertEquals(Rank.ACE, Rank.fromKeyword("A"));
        assertEquals(Rank.TWO, Rank.fromKeyword("2"));
        assertEquals(Rank.THREE, Rank.fromKeyword("3"));
        assertEquals(Rank.FOUR, Rank.fromKeyword("4"));
        assertEquals(Rank.FIVE, Rank.fromKeyword("5"));
        assertEquals(Rank.SIX, Rank.fromKeyword("6"));
        assertEquals(Rank.SEVEN, Rank.fromKeyword("7"));
        assertEquals(Rank.EIGHT, Rank.fromKeyword("8"));
        assertEquals(Rank.NINE, Rank.fromKeyword("9"));
        assertEquals(Rank.TEN, Rank.fromKeyword("T"));
        assertEquals(Rank.JACK, Rank.fromKeyword("J"));
        assertEquals(Rank.QUEEN, Rank.fromKeyword("Q"));
        assertEquals(Rank.KING, Rank.fromKeyword("K"));
    }

    @Test
    public void shouldReturnNullForInvalidKeywordInRank() {
        assertNull(Rank.fromKeyword("invalid"));
        assertNull(Rank.fromKeyword(""));
    }

    @Test
    public void shouldBeAbleToGetNameForRank() {
        assertEquals("ACE", Rank.ACE.getName());
        assertEquals("TWO", Rank.TWO.getName());
        assertEquals("THREE", Rank.THREE.getName());
        assertEquals("FOUR", Rank.FOUR.getName());
        assertEquals("FIVE", Rank.FIVE.getName());
        assertEquals("SIX", Rank.SIX.getName());
        assertEquals("SEVEN", Rank.SEVEN.getName());
        assertEquals("EIGHT", Rank.EIGHT.getName());
        assertEquals("NINE", Rank.NINE.getName());
        assertEquals("TEN", Rank.TEN.getName());
        assertEquals("JACK", Rank.JACK.getName());
        assertEquals("QUEEN", Rank.QUEEN.getName());
        assertEquals("KING", Rank.KING.getName());
    }

    @Test
    public void shouldBeAbleToGetSuitFromKeyword() {
        assertEquals(Suit.HEARTS, Suit.fromKeyword("H"));
        assertEquals(Suit.DIAMONDS, Suit.fromKeyword("D"));
        assertEquals(Suit.CLUBS, Suit.fromKeyword("C"));
        assertEquals(Suit.SPADES, Suit.fromKeyword("S"));
    }

    @Test
    public void shouldReturnNullForInvalidKeywordInSuit() {
        assertNull(Suit.fromKeyword("invalid"));
        assertNull(Suit.fromKeyword(""));
    }

    @Test
    public void shouldBeAbleToGetNameForSuit() {
        assertEquals("H", Suit.HEARTS.getName());
        assertEquals("D", Suit.DIAMONDS.getName());
        assertEquals("C", Suit.CLUBS.getName());
        assertEquals("S", Suit.SPADES.getName());
    }

}