package com.amaap.pokerhandranking.service;

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

    @BeforeEach
    void setp() {
        cardParser = new CardParser();
        inMemoryHandRepository=InMemoryHandRepository.getInstance();
        handService=new HandService(cardParser,inMemoryHandRepository);
        inMemoryHandRepository.clear();
    }


    @Test
    void shouldBeAbleToReturnTrueIfFiveCardsAreAdded() throws Exception, DuplicateCardException {
        // arrange
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
        List<String> receivedCards = new ArrayList<>();
        receivedCards.add("HA");
        receivedCards.add("S2");
        receivedCards.add("5D");
        receivedCards.add("C7");
        receivedCards.add("ST");

        // act
        boolean actual = handService.receiveCards(receivedCards);

        // assert
        assertFalse(actual);


    }

    @Test
    void shouldBeAbelToGetTheStoredCardFromDatabase() throws DuplicateCardException, Exception {
        // arrange
        List<String> receivedCards = new ArrayList<>();
        receivedCards.add("HA");
        receivedCards.add("S2");
        receivedCards.add("D5");
        receivedCards.add("C7");
        receivedCards.add("ST");

        // act
        handService.receiveCards(receivedCards);
       int storedCardSize= inMemoryHandRepository.getCards().size();

       // assert
       assertEquals(receivedCards.size(),storedCardSize);

    }

}