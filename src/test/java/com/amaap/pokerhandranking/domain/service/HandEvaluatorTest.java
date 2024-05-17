package com.amaap.pokerhandranking.domain.service;

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
    void shouldBeAbleToIdentifyRoyalFlush() {
        List<String> hand = Arrays.asList("SA", "SK", "SQ", "SJ", "ST");
        String result = handEvaluator.evaluate(hand);
        assertEquals("RoyalFlush", result);
    }

    @Test
    void shouldBeAbleToIdentifyStraightFlush() {
        List<String> hand = Arrays.asList("S9", "S8", "S7", "S6", "S5");
        String result = handEvaluator.evaluate(hand);
        assertEquals("StraightFlush", result);
    }

    @Test
    void shouldBeAbleToIdentifyFourOfKind() {
        List<String> hand = Arrays.asList("HA", "DA", "CA", "SA", "H2");
        String result = handEvaluator.evaluate(hand);
        assertEquals("FourOfKind", result);
    }

    @Test
    void shouldBeAbleToIdentifyFullHouse() {
        List<String> hand = Arrays.asList("HA", "DA", "CA", "HK", "DK");
        String result = handEvaluator.evaluate(hand);
        assertEquals("FullHouse", result);
    }

    @Test
    void shouldBeAbleToIdentifyFlush() {
        List<String> hand = Arrays.asList("S2", "S4", "S6", "S8", "ST");
        String result = handEvaluator.evaluate(hand);
        assertEquals("Flush", result);
    }

    @Test
    void shouldBeAbleToIdentifyStraight() {
        List<String> hand = Arrays.asList("S9", "H8", "D7", "C6", "S5");
        String result = handEvaluator.evaluate(hand);
        assertEquals("Straight", result);
    }

    @Test
    void shouldBeAbleToIdentifyThreeOfKind() {
        List<String> hand = Arrays.asList("HA", "DA", "CA", "H2", "D3");
        String result = handEvaluator.evaluate(hand);
        assertEquals("ThreeOfKind", result);
    }

    @Test
    void shouldBeAbleToIdentifyTwoPair() {
        List<String> hand = Arrays.asList("HA", "DA", "HK", "DK", "H2");
        String result = handEvaluator.evaluate(hand);
        assertEquals("TwoPair", result);
    }

    @Test
    void shouldBeAbleToIdentifyPair() {
        List<String> hand = Arrays.asList("HA", "DA", "H2", "D3", "S4");
        String result = handEvaluator.evaluate(hand);
        assertEquals("Pair", result);
    }

    @Test
    void shouldBeAbleToIdentifyHighCard() {
        List<String> hand = Arrays.asList("Dk", "HA", "CQ", "SJ", "H2");
        String result = handEvaluator.evaluate(hand);
        assertEquals("HighCard: KING of DIAMONDS", result);
    }
}


