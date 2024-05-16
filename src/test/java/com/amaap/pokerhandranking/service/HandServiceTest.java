package com.amaap.pokerhandranking.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandServiceTest {

    @Test
    void shouldBeAbleToReturnTrueIfFiveCardsAreAdded()
    {
        // arrange

        HandService handService=new HandService();
        List<String> receivedCards=new ArrayList<>();
        receivedCards.add("HA");
        receivedCards.add("S2");
        receivedCards.add("D5");
        receivedCards.add("C7");
        receivedCards.add("ST");

        // act & assert
       assertTrue(handService.receiveCards(receivedCards));

    }

}