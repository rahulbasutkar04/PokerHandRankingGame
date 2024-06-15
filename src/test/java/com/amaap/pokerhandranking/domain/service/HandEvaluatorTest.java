package com.amaap.pokerhandranking.domain.service;

import com.amaap.pokerhandranking.domain.service.exception.InvalidCardNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandEvaluatorTest {

    private HandEvaluator handEvaluator;

    @BeforeEach
    void setUp() {
        handEvaluator = new HandEvaluator();
    }

    @Test
    void shouldBeAbleToIdentifyRoyalFlush() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("SA", "SK", "SQ", "SJ", "ST");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("RoyalFlush", result);
    }

    @Test
    void shouldBeAbleToIdentifyStraightFlush() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("S9", "S8", "S7", "S6", "S5");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("StraightFlush", result);
    }

    @Test
    void shouldBeAbleToIdentifyFourOfKind() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("HA", "DA", "CA", "SA", "H2");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("FourOfKind", result);
    }

    @Test
    void shouldBeAbleToIdentifyFullHouse() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("HA", "DA", "CA", "HK", "DK");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("FullHouse", result);
    }

    @Test
    void shouldBeAbleToIdentifyFlush() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("S2", "S4", "S6", "S8", "ST");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("Flush", result);
    }

    @Test
    void shouldBeAbleToIdentifyStraight() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("S9", "H8", "D7", "C6", "S5");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("Straight", result);
    }

    @Test
    void shouldBeAbleToIdentifyThreeOfKind() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("HA", "DA", "CA", "H2", "D3");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("ThreeOfKind", result);
    }

    @Test
    void shouldBeAbleToIdentifyTwoPair() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("HA", "DA", "HK", "DK", "H2");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("TwoPair", result);
    }

    @Test
    void shouldBeAbleToIdentifyPair() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("HA", "DA", "H2", "D3", "S4");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("Pair", result);
    }

    @Test
    void shouldBeAbleToIdentifyHighCard() throws InvalidCardNameException {
        // arrange
        List<String> hand = Arrays.asList("Dk", "HA", "CQ", "SJ", "H2");

        // act
        String result = handEvaluator.evaluate(hand);

        // assert
        assertEquals("HighCard: KING of DIAMONDS", result);
    }
}


