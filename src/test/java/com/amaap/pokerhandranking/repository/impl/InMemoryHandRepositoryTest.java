package com.amaap.pokerhandranking.repository.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHandRepositoryTest {

    private InMemoryHandRepository repository;

    @BeforeEach
    void setUp() {
        repository = InMemoryHandRepository.getInstance();
        repository.clear();

    }

    @Test
    void shouldBeAbleToInsertCardsIntoHandTable() {
        // arrange
        List<String> cards = Arrays.asList("D2", "C5", "S7", "HT", "HA");

        // act
        repository.insertIntoHandTable(cards);

        // assert
        assertEquals(cards, repository.getCards());
    }

    @Test
    void shouldBeAbleToRetrieveInsertedCardsFromHandTable() {
        // arrange
        List<String> cards = Arrays.asList("D2", "C5", "S7", "HT", "HA");
        repository.insertIntoHandTable(cards);

        // act
        List<String> retrievedCards = repository.getCards();

        // assert
        assertEquals(cards, retrievedCards);
    }

    @Test
    void shouldBeAbleToClearHandTable() {
        // arrange
        List<String> cards = Arrays.asList("D2", "C5", "S7", "HT", "HA");
        repository.insertIntoHandTable(cards);

        // act
        repository.clear();

        // assert
        assertTrue(repository.getCards().isEmpty());
    }

    @Test
    void shouldBeAbleToReturnSingleInstance() {
        // arrange
        InMemoryHandRepository instance1;
        InMemoryHandRepository instance2;

        // act
        instance1 = InMemoryHandRepository.getInstance();
        instance2 = InMemoryHandRepository.getInstance();

        // assert
        assertSame(instance1, instance2);
    }

}