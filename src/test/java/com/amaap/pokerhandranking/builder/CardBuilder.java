package com.amaap.pokerhandranking.builder;

import java.util.ArrayList;
import java.util.List;

public class CardBuilder {
    List<String> cards = new ArrayList<>();
    public  List<String> getValidCards()
    {
        cards.add("HA");
        cards.add("S2");
        cards.add("D5");
        cards.add("C7");
        cards.add("ST");

        return cards;
    }
    public  List<String> getInValidCards()
    {
        cards.add("HA");
        cards.add("S2");
        cards.add("5D");
        cards.add("C7");
        cards.add("ST");

        return cards;
    }
    public  List<String> getDuplicateCards()
    {
        cards.add("HA");
        cards.add("S2");
        cards.add("D5");
        cards.add("C7");
        cards.add("HA");

        return cards;
    }
    public  List<String> getExtraCountCards()
    {
        cards.add("HA");
        cards.add("S2");
        cards.add("D5");
        cards.add("C7");
        cards.add("HA");
        cards.add("DA");

        return cards;
    }
}
