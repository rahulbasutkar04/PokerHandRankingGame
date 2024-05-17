package com.amaap.pokerhandranking.domain.service.impl;

import com.amaap.pokerhandranking.domain.model.Card;
import com.amaap.pokerhandranking.domain.service.HandRanking;

import java.util.List;

public class StraightFlush implements HandRanking {
    @Override
    public boolean evaluate(List<Card> hand) {
        Flush flush=new Flush();
        Straight straight=new Straight();
        return flush.evaluate(hand) && straight.evaluate(hand);
    }
}
