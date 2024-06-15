package com.amaap.pokerhandranking.domain.service;

import com.amaap.pokerhandranking.domain.model.entity.Card;

import java.util.List;

public interface HandRanking {
    boolean evaluate(List<Card> hand);
}
