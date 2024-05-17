package com.amaap.pokerhandranking.controller;

import com.amaap.pokerhandranking.builder.CardBuilder;
import com.amaap.pokerhandranking.controller.dto.Http;
import com.amaap.pokerhandranking.controller.dto.Response;
import com.amaap.pokerhandranking.repository.impl.InMemoryHandRepository;
import com.amaap.pokerhandranking.service.RankEvaluatorService;
import com.amaap.pokerhandranking.service.exception.CardsNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class RankControllerTest {
    InMemoryHandRepository inMemoryHandRepository;

    @BeforeEach
    void setup() {
        inMemoryHandRepository = InMemoryHandRepository.getInstance();
    }

    @Test
    void shouldBeAbleToGetTheHandRankingOfTheCard() throws CardsNotFoundException {
        // arrange
        CardBuilder cardBuilder = new CardBuilder();
        RankController rankController = new RankController();
        inMemoryHandRepository.insertIntoHandTable(cardBuilder.getValidCards());
        Response expected = new Response(Http.OK, "Request Submitted");

        // act
        Response actual = rankController.getHandRank();

        // assert
        assertEquals(actual, expected);
    }

}


