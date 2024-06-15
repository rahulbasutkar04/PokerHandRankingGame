package com.amaap.pokerhandranking.controller;

import com.amaap.pokerhandranking.builder.CardBuilder;
import com.amaap.pokerhandranking.controller.dto.Http;
import com.amaap.pokerhandranking.controller.dto.Response;
import com.amaap.pokerhandranking.domain.service.CardParser;
import com.amaap.pokerhandranking.domain.service.exception.InvalidCardNameException;
import com.amaap.pokerhandranking.repository.impl.InMemoryHandRepository;
import com.amaap.pokerhandranking.service.HandService;
import com.amaap.pokerhandranking.service.exception.CardsNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankControllerTest {
   private  InMemoryHandRepository inMemoryHandRepository;
   private HandController handController;
   private HandService handService;

    @BeforeEach
    void setup() {
        inMemoryHandRepository = InMemoryHandRepository.getInstance();
        handService=new HandService(new CardParser(),inMemoryHandRepository);
        handController=new HandController(handService);
    }

    @Test
    void shouldBeAbleToGetTheHandRankingOfTheCard() throws CardsNotFoundException, InvalidCardNameException {
        // arrange
        CardBuilder cardBuilder = new CardBuilder();
        RankController rankController = new RankController();
        handController.getCards(cardBuilder.getValidCards());

        Response expected = new Response(Http.OK, "Request Submitted");

        // act
        Response actual = rankController.getHandRank();

        // assert
        assertEquals(actual, expected);
    }

}


