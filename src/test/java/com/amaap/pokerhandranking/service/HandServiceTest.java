package com.amaap.pokerhandranking.service;

import com.amaap.pokerhandranking.builder.CardBuilder;
import com.amaap.pokerhandranking.domain.service.CardParser;
import com.amaap.pokerhandranking.repository.impl.InMemoryHandRepository;
import com.amaap.pokerhandranking.service.exception.DuplicateCardException;
import com.amaap.pokerhandranking.service.exception.InvalidCardCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandServiceTest {
    CardParser cardParser;
    HandService handService;
    InMemoryHandRepository inMemoryHandRepository;
    CardBuilder cardBuilder;

    @BeforeEach
    void setup() {
        cardParser = new CardParser();
        inMemoryHandRepository = InMemoryHandRepository.getInstance();
        handService = new HandService(cardParser, inMemoryHandRepository);
        cardBuilder = new CardBuilder();
        inMemoryHandRepository.clear();
    }


    @Test
    void shouldBeAbleToReturnTrueIfFiveCardsAreAdded() throws Exception, DuplicateCardException {
        // arrange
        List<String> receivedCards = cardBuilder.getValidCards();

        // act & assert
        assertTrue(handService.receiveCards(receivedCards));
    }

    @Test
    void shouldThrowExceptionIfMoreThanFiveCardsAreGiven() {
        // arrange
        List<String> receivedCards = cardBuilder.getExtraCountCards();

        // act & assert
        assertThrows(InvalidCardCountException.class, () -> {
            handService.receiveCards(receivedCards);
        });
    }

    @Test
    void shouldThrowExceptionIfDuplicateCardFound() {
        // arrange
        List<String> receivedCards = cardBuilder.getDuplicateCards();

        // act & assert
        assertThrows(DuplicateCardException.class, () -> {
            handService.receiveCards(receivedCards);
        });
    }

    @Test
    void shouldThrowExceptionIfNoCardIsPassed() {
        // arrange
        List<String> receivedCards = new ArrayList<>();

        // act & assert
        assertThrows(InvalidCardCountException.class, () -> {
            handService.receiveCards(receivedCards);
        });
    }

    @Test
    void shouldReturnFalseIfGivenCardListHasInvalidTypeOfCard() throws DuplicateCardException, Exception {
        // arrange
        List<String> receivedCards = cardBuilder.getInValidCards();

        // act
        boolean actual = handService.receiveCards(receivedCards);

        // assert
        assertFalse(actual);

    }

    @Test
    void shouldBeAbelToGetTheStoredCardFromDatabase() throws DuplicateCardException, Exception {
        // arrange
        List<String> receivedCards = cardBuilder.getValidCards();

        // act
        handService.receiveCards(receivedCards);
        int storedCardSize = inMemoryHandRepository.getCards().size();

        // assert
        assertEquals(receivedCards.size(), storedCardSize);

    }

}