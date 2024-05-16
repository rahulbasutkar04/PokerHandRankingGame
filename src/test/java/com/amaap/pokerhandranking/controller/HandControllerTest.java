package com.amaap.pokerhandranking.controller;

import com.amaap.pokerhandranking.controller.dto.Http;
import com.amaap.pokerhandranking.controller.dto.Response;
import com.amaap.pokerhandranking.domain.service.CardParser;
import com.amaap.pokerhandranking.repository.impl.InMemoryHandRepository;
import com.amaap.pokerhandranking.service.HandService;
import com.amaap.pokerhandranking.service.exception.DuplicateCardException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandControllerTest {

    HandService handService;
    CardParser cardParser;
    InMemoryHandRepository inMemoryHandRepository;

    @BeforeEach
    void setup() {
        cardParser = new CardParser();
        inMemoryHandRepository = InMemoryHandRepository.getInstance();
        handService = new HandService(cardParser, inMemoryHandRepository);
        inMemoryHandRepository.clear();
    }

    @Test
    void shouldBeAbleToReceiveCards() throws Exception, DuplicateCardException {
        // arrange
        HandController handController = new HandController(handService);
        List<String> receivedCards = new ArrayList<>();
        receivedCards.add("HA");
        receivedCards.add("S2");
        receivedCards.add("D5");
        receivedCards.add("C7");
        receivedCards.add("ST");

        Response expected = new Response(Http.OK, "Cards Submitted");
        // act
        Response actual = handController.receiveCards(receivedCards);

        // assert

        assertEquals(actual, expected);
    }
}
