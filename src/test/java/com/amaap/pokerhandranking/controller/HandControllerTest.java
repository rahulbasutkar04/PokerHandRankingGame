package com.amaap.pokerhandranking.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HandControllerTest {

    @Test
    void shouldBeAbleToReceiveCards()
    {
        // arrange
        CardController cardController=new CardController();
        List<String> receivedCards=new ArrayList<>();
        receivedCards.add("HA");
        receivedCards.add("S2");
        receivedCards.add("D5");
        receivedCards.add("C7");
        receivedCards.add("ST");

        Response expected=new Response(Http.OK,"cards Submitted..");
        // act
        Response actual= cardController.reviceCards(receivedCards);

        // assert

        assertEquals(actual,expected);
    }
}
