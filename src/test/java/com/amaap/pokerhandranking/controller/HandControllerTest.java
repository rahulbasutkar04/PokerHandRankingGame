package com.amaap.pokerhandranking.controller;

import com.amaap.pokerhandranking.builder.CardBuilder;
import com.amaap.pokerhandranking.controller.dto.Http;
import com.amaap.pokerhandranking.controller.dto.Response;
import com.amaap.pokerhandranking.domain.service.CardParser;
import com.amaap.pokerhandranking.repository.impl.InMemoryHandRepository;
import com.amaap.pokerhandranking.service.HandService;
import com.amaap.pokerhandranking.service.exception.DuplicateCardException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandControllerTest {

    HandService handService;
    CardParser cardParser;
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
    void shouldBeAbleToRespondWithOkIfCardsAreSubmitted() throws Exception, DuplicateCardException {
        // arrange
        HandController handController = new HandController(handService);
        List<String> receivedCards = cardBuilder.getValidCards();

        Response expected = new Response(Http.OK, "Cards Submitted");
        // act
        Response actual = handController.receiveCards(receivedCards);

        // assert
        assertEquals(actual, expected);
    }
    @Test
    void shouldBeAbleToRespondWithBADREQUESTIfCardsAreNOTSubmitted(){
        // arrange
        HandController handController = new HandController(handService);
        List<String> receivedCards = cardBuilder.getDuplicateCards();

        Response expected = new Response(Http.BAD_REQUEST, "Duplicate cards found: [HA]");
        // act
        Response actual = handController.receiveCards(receivedCards);

        // assert
        assertEquals(actual, expected);
    }
}
