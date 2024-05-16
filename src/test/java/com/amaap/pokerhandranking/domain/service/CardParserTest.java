package com.amaap.pokerhandranking.domain.service;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.service.exception.InvalidCardTypeException;
import com.amaap.pokerhandranking.service.exception.InvalidCardCountException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardParserTest {

    @Test
    void shouldBeAbleToReturnTheCardNameIfCardIsValidCard() throws InvalidCardCountException, InvalidCardTypeException {
        // arrange

        CardParser cardParser=new CardParser();
        String card="ST";
        String expectedCard="STEN";

        // act
        Card actualCard=cardParser.parseCard(card);

        // assert
        assertEquals(expectedCard,actualCard.toString());
    }
    @Test
    void shouldThrowExceptionIfCardIsInValidCard() {
        // arrange

        CardParser cardParser=new CardParser();
        String card="TS";

        // act & assert
        assertThrows(InvalidCardTypeException.class,()->{
            cardParser.parseCard(card);

        });
     }
     @Test
    void shouldThrowExceptionIfCardCountIsInvalid() {
        // arrange

        CardParser cardParser=new CardParser();
        String card="T";

        // act & assert
        assertThrows(InvalidCardCountException.class,()->{
            cardParser.parseCard(card);

        });
     }

     @Test
    void shouldBeAbleToValidateTheListOfCard() throws Exception {
         // arrange
         CardParser cardParser=new CardParser();
         List<String> receivedCards=new ArrayList<>();
         receivedCards.add("HA");
         receivedCards.add("S2");
         receivedCards.add("D5");
         receivedCards.add("C7");
         receivedCards.add("ST");

         // act
        boolean isValidCards=cardParser.validateCards(receivedCards);

         // assert
        assertTrue(isValidCards);

     }
     @Test
    void shouldThrowExceptionIfListOfCardContainsInValidCard()  {
         // arrange
         CardParser cardParser=new CardParser();
         List<String> receivedCards=new ArrayList<>();
         receivedCards.add("HA");
         receivedCards.add("2S");
         receivedCards.add("D5");
         receivedCards.add("C7");
         receivedCards.add("ST");

         // act & assert
        assertThrows(InvalidCardTypeException.class,()->{
            cardParser.validateCards(receivedCards);
        });
     }

}