package com.amaap.pokerhandranking.domain.service;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.service.impl.*;

import java.util.ArrayList;
import java.util.List;

public class HandEvaluator {

    private final CardConvertor cardConvertor = new CardConvertor();

    public String evaluate(List<String> hand) {
        List<Card> cards = cardConvertor.convertToCardList(hand);

        List<HandRanking> evaluators = new ArrayList<>();
        evaluators.add(new RoyalFlush());
        evaluators.add(new StraightFlush());
        evaluators.add(new Flush());
        evaluators.add(new Straight());
        evaluators.add(new FullHouse());
        evaluators.add(new TwoPair());
        evaluators.add(new Pair());
        evaluators.add(new ThreeOfKind());
        evaluators.add(new FourOfKind());

        for (HandRanking evaluator : evaluators) {
            if (evaluator.evaluate(cards)) {
                return evaluator.getClass().getSimpleName();
            }
        }

        HighCard highCardEvaluator = new HighCard();
        highCardEvaluator.evaluate(cards);
        Card highestCard = highCardEvaluator.getHighestCard(cards);
        return "HighCard: " + highestCard.getRank() + " of " + highestCard.getSuit();
    }
}
