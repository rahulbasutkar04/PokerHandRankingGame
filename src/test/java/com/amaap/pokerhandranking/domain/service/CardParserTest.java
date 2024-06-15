package com.amaap.pokerhandranking.domain.service;

import com.amaap.pokerhandranking.builder.CardBuilder;
import com.amaap.pokerhandranking.domain.model.entity.Card;
import com.amaap.pokerhandranking.domain.service.exception.InvalidCardTypeException;
import com.amaap.pokerhandranking.service.exception.InvalidCardCountException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardParserTest {


    CardBuilder cardBuilder = new CardBuilder();
    CardParser cardParser = new CardParser();


    @Test
    void shouldBeAbleToReturnTheCardNameIfCardIsValidCard() throws InvalidCardCountException, InvalidCardTypeException {
        // arrange
        String card = "ST";
        String expectedCard = "STEN";

        // act
        Card actualCard = cardParser.parseCard(card);

        // assert
        assertEquals(expectedCard, actualCard.toString());
    }

    @Test
    void shouldThrowExceptionIfCardIsInValidCard() {
        // arrange
        String card = "TS";

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            cardParser.parseCard(card);
        });
    }

    @Test
    void shouldThrowExceptionIfCardCountIsInvalid() {
        // arrange
        String card = "T";

        // act & assert
        assertThrows(InvalidCardCountException.class, () -> {
            cardParser.parseCard(card);
        });
    }

    @Test
    void shouldBeAbleToValidateTheListOfCard() throws Exception {
        // arrange
        CardParser cardParser = new CardParser();
        List<String> receivedCards = cardBuilder.getValidCards();

        // act
        boolean isValidCards = cardParser.validateCards(receivedCards);

        // assert
        assertTrue(isValidCards);

    }

    @Test
    void shouldThrowExceptionIfListOfCardContainsInValidCard() {
        // arrange
        CardParser cardParser = new CardParser();
        List<String> receivedCards = cardBuilder.getInValidCards();

        // act & assert
        assertThrows(InvalidCardTypeException.class, () -> {
            cardParser.validateCards(receivedCards);
        });
    }
}