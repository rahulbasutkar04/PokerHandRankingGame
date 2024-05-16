package com.amaap.pokerhandranking.service;

import com.amaap.pokerhandranking.domain.service.CardParser;
import com.amaap.pokerhandranking.service.exception.DuplicateCardException;
import com.amaap.pokerhandranking.service.exception.InvalidCardCountException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HandService {
    private  final CardParser cardParser;

    public HandService(CardParser cardParser) {
        this.cardParser = cardParser;
    }

    public boolean receiveCards(List<String> cards) throws Exception, DuplicateCardException {
        if (cards.size() != 5)
            throw new InvalidCardCountException("Card count should be 5 your given Card  count is:" + cards.size());
        List<String> duplicates = findDuplicates(cards);
        if (!duplicates.isEmpty()) {
            throw new DuplicateCardException("Duplicate cards found: " + duplicates);
        }

         if(cardParser.validateCards(cards)){
            return  true;
        }

         return  false;
    }

    private static List<String> findDuplicates(List<String> list) {
        Set<String> elements = new HashSet<>();
        return list.stream()
                .filter(n -> !elements.add(n))
                .collect(Collectors.toList());
    }
}
