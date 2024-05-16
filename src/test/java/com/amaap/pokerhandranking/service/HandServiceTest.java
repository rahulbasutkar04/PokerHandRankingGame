package com.amaap.pokerhandranking.service;

import com.amaap.pokerhandranking.service.exception.DuplicateCardException;
import com.amaap.pokerhandranking.service.exception.InvalidCardCountException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HandServiceTest {

    @Test
    void shouldBeAbleToReturnTrueIfFiveCardsAreAdded() throws InvalidCardCountException, DuplicateCardException {
        // arrange
        HandService handService = new HandService();
        List<String> receivedCards = new ArrayList<>();
        receivedCards.add("HA");
        receivedCards.add("S2");
        receivedCards.add("D5");
        receivedCards.add("C7");
        receivedCards.add("ST");

        // act & assert
        assertTrue(handService.receiveCards(receivedCards));

    }

    @Test
    void shouldThrowExceptionIfMoreThanFiveCardsAreGiven() {
        // arrange
        HandService handService = new HandService();
        List<String> receivedCards = new ArrayList<>();
        receivedCards.add("HA");
        receivedCards.add("S2");
        receivedCards.add("D5");
        receivedCards.add("C7");
        receivedCards.add("ST");
        receivedCards.add("C3");

        // act & assert
        assertThrows(InvalidCardCountException.class, () -> {
            handService.receiveCards(receivedCards);
        });

    }

    @Test
    void shouldThrowExceptionIfDuplicateCardFound() {
        // arrange
        HandService handService = new HandService();
        List<String> receivedCards = new ArrayList<>();
        receivedCards.add("HA");
        receivedCards.add("S2");
        receivedCards.add("D5");
        receivedCards.add("C7");
        receivedCards.add("HA");

        // act & assert
        assertThrows(DuplicateCardException.class, () -> {
            handService.receiveCards(receivedCards);
        });
    }    @Test
    void shouldThrowExceptionIfNoCardIsPassed() {
        // arrange
        HandService handService = new HandService();
        List<String> receivedCards = new ArrayList<>();

        // act & assert
        assertThrows(InvalidCardCountException.class, () -> {
            handService.receiveCards(receivedCards);
        });
    }

}