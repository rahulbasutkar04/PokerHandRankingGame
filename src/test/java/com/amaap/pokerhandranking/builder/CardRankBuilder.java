package com.amaap.pokerhandranking.builder;

import com.amaap.pokerhandranking.domain.model.entity.Card;
import com.amaap.pokerhandranking.domain.model.valueobject.Rank;
import com.amaap.pokerhandranking.domain.model.valueobject.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardRankBuilder {
    List<Card> hand = new ArrayList<>();

    public  List<Card> getValidFlushCards()
    {

        hand.add(new Card(Suit.SPADES, Rank.TWO));
        hand.add(new Card(Suit.SPADES, Rank.FOUR));
        hand.add(new Card(Suit.SPADES, Rank.SIX));
        hand.add(new Card(Suit.SPADES, Rank.EIGHT));
        hand.add(new Card(Suit.SPADES, Rank.TEN));
        return hand;
    }
    public  List<Card> getInValidFlushCards()
    {

        hand.add(new Card(Suit.SPADES, Rank.TWO));
        hand.add(new Card(Suit.HEARTS, Rank.FOUR));
        hand.add(new Card(Suit.SPADES, Rank.SIX));
        hand.add(new Card(Suit.SPADES, Rank.EIGHT));
        hand.add(new Card(Suit.SPADES, Rank.TEN));

        return hand;
    }

    public  List<Card> getValidThreeOfKindCard()
    {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.ACE),
                new Card(Suit.DIAMONDS, Rank.ACE),
                new Card(Suit.SPADES, Rank.ACE),
                new Card(Suit.HEARTS, Rank.TWO)
        );

        return hand;
    }  public  List<Card> getInValidThreeOfKindCard()
    {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.KING),
                new Card(Suit.DIAMONDS, Rank.QUEEN),
                new Card(Suit.SPADES, Rank.JACK),
                new Card(Suit.HEARTS, Rank.TWO)
        );

        return hand;
    }

    public List<Card> getStraightFlushCards() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.SPADES, Rank.TEN));
        hand.add(new Card(Suit.SPADES, Rank.JACK));
        hand.add(new Card(Suit.SPADES, Rank.QUEEN));
        hand.add(new Card(Suit.SPADES, Rank.KING));
        hand.add(new Card(Suit.SPADES, Rank.ACE));
        return hand;
    }

    public List<Card> getStraightCards() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.SPADES, Rank.TWO));
        hand.add(new Card(Suit.HEARTS, Rank.THREE));
        hand.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        hand.add(new Card(Suit.CLUBS, Rank.FIVE));
        hand.add(new Card(Suit.SPADES, Rank.SIX));
        return hand;
    }

    public List<Card> getTwoPairCards() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.TWO),
                new Card(Suit.CLUBS, Rank.TWO),
                new Card(Suit.DIAMONDS, Rank.THREE),
                new Card(Suit.SPADES, Rank.THREE),
                new Card(Suit.HEARTS, Rank.FOUR)
        );
        return hand;
    }

    public List<Card> getFullHouseCards() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.ACE),
                new Card(Suit.DIAMONDS, Rank.ACE),
                new Card(Suit.SPADES, Rank.KING),
                new Card(Suit.HEARTS, Rank.KING)
        );
        return hand;
    }

    public List<Card> getFourOfKindCards() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.ACE),
                new Card(Suit.DIAMONDS, Rank.ACE),
                new Card(Suit.SPADES, Rank.ACE),
                new Card(Suit.HEARTS, Rank.KING)
        );
        return hand;
    }

    public List<Card> getValidPairCards() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.ACE),
                new Card(Suit.DIAMONDS, Rank.TWO),
                new Card(Suit.SPADES, Rank.THREE),
                new Card(Suit.HEARTS, Rank.FOUR)
        );

        return hand;
    }

    public List<Card> getInvalidPairCards() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.KING),
                new Card(Suit.DIAMONDS, Rank.QUEEN),
                new Card(Suit.SPADES, Rank.JACK),
                new Card(Suit.HEARTS, Rank.FOUR)
        );

        return hand;
    }
    public List<Card> getValidRoyalFlushCards() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.TEN),
                new Card(Suit.HEARTS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.KING),
                new Card(Suit.HEARTS, Rank.ACE)
        );

        return hand;
    }
    public List<Card> getInValidRoyalFlushCards() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.SPADES, Rank.TEN),
                new Card(Suit.HEARTS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.KING),
                new Card(Suit.HEARTS, Rank.ACE)
        );

        return hand;
    }
     public List<Card> getValidStraightCards() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.FIVE),
                new Card(Suit.DIAMONDS, Rank.SIX),
                new Card(Suit.CLUBS, Rank.SEVEN),
                new Card(Suit.SPADES, Rank.EIGHT),
                new Card(Suit.HEARTS, Rank.NINE)
        );

        return hand;
    }
    public List<Card> getInValidStraightCards() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.SPADES, Rank.TEN),
                new Card(Suit.HEARTS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.KING),
                new Card(Suit.HEARTS, Rank.ACE)
        );

        return hand;
    }


    public List<Card> getValidThreeOfKindCards() {
        return Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.ACE),
                new Card(Suit.DIAMONDS, Rank.ACE),
                new Card(Suit.SPADES, Rank.KING),
                new Card(Suit.HEARTS, Rank.TWO)
        );
    }

    public List<Card> getInValidThreeOfKindCards() {
        return Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.KING),
                new Card(Suit.DIAMONDS, Rank.QUEEN),
                new Card(Suit.SPADES, Rank.JACK),
                new Card(Suit.HEARTS, Rank.TWO)
        );
    }

    public List<Card> getValidTwoPairCards() {
        return Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.ACE),
                new Card(Suit.DIAMONDS, Rank.KING),
                new Card(Suit.SPADES, Rank.KING),
                new Card(Suit.HEARTS, Rank.TWO)
        );
    }

    public List<Card> getInvalidTwoPairCards() {
        return Arrays.asList(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.KING),
                new Card(Suit.DIAMONDS, Rank.QUEEN),
                new Card(Suit.SPADES, Rank.JACK),
                new Card(Suit.HEARTS, Rank.TWO)
        );
    }
}







