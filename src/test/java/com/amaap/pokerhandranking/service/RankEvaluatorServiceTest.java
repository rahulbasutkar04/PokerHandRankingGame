package com.amaap.pokerhandranking.service;

import com.amaap.pokerhandranking.controller.HandController;
import com.amaap.pokerhandranking.domain.service.CardParser;
import com.amaap.pokerhandranking.domain.service.HandEvaluator;
import com.amaap.pokerhandranking.repository.impl.InMemoryHandRepository;
import com.amaap.pokerhandranking.service.exception.DuplicateCardException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankEvaluatorServiceTest {
    private CardParser cardParser;
    private InMemoryHandRepository inMemoryHandRepository;
    private HandService handService;
    private HandController handController;
    private HandEvaluator handEvaluator;
    private RankEvaluatorService rankEvaluatorService;

    @BeforeEach
    void setUp() {
        cardParser = new CardParser();
        inMemoryHandRepository = InMemoryHandRepository.getInstance();
        handService = new HandService(cardParser, inMemoryHandRepository);
        handController = new HandController(handService);
        handEvaluator = new HandEvaluator();
        rankEvaluatorService = new RankEvaluatorService(inMemoryHandRepository, handEvaluator);
    }

    @Test
    void shouldBeAbleToReturnCardRanking() throws DuplicateCardException, Exception {
        // arrange
        List<String> cards=new ArrayList<>();
        cards.add("S2");
        cards.add("D5");
        cards.add("C7");
        cards.add("ST");
        cards.add("HA");
        handController.receiveCards(cards);

        // act
        rankEvaluatorService.getRank();

        // assert
        assertEquals("HighCard", rankEvaluatorService.getHandRank());
    }

    @Test
    void shouldBeAbleToReturnStraightRanking() throws DuplicateCardException, Exception {
        // arrange
        List<String> cards=new ArrayList<>();
        cards.add("S2");
        cards.add("D3");
        cards.add("C4");
        cards.add("H5");
        cards.add("D6");
        handController.receiveCards(cards);

        // act
        rankEvaluatorService.getRank();

        // assert
        assertEquals("Straight", rankEvaluatorService.getHandRank());
    }

    @Test
    void shouldBeAbleToReturnRoyalFlushRanking() throws DuplicateCardException, Exception {
        // arrange
        List<String> cards=new ArrayList<>();
        cards.add("ST");
        cards.add("SJ");
        cards.add("SQ");
        cards.add("SK");
        cards.add("SA");
        handController.receiveCards(cards);

        // act
        rankEvaluatorService.getRank();

        // assert
        assertEquals("RoyalFlush", rankEvaluatorService.getHandRank());
    }

}