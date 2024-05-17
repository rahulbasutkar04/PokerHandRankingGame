package com.amaap.pokerhandranking.controller;

import com.amaap.pokerhandranking.controller.dto.Http;
import com.amaap.pokerhandranking.controller.dto.Response;
import com.amaap.pokerhandranking.service.exception.CardsNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankControllerTest {

    @Test
    void shouldBeAbleToGetTheHandRankingOfTheCard() throws CardsNotFoundException {
        // arrange
         RankController rankController=new RankController();
         Response expected=new Response(Http.OK,"Request Submitted");
        // act
        Response actual=rankController.getHandRank();

        // assert
        assertEquals(actual,expected);
    }
}
