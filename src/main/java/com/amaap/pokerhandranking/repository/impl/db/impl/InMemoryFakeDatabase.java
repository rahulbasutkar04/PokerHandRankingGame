package com.amaap.pokerhandranking.repository.impl.db.impl;

import com.amaap.pokerhandranking.repository.impl.db.FakeDatabase;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFakeDatabase implements FakeDatabase {
    private static InMemoryFakeDatabase instance;
    private List<String> cards = new ArrayList<>();

    private InMemoryFakeDatabase() {
    }

    public static synchronized InMemoryFakeDatabase getInstance() {
        if (instance == null) {
            instance = new InMemoryFakeDatabase();
        }
        return instance;
    }

    @Override
    public void insertIntoHandTable(List<String> cards) {
        this.cards.addAll(cards);
    }

    @Override
    public List<String> getCards() {
        return cards;
    }

    public void clearStorage() {
        cards.clear();
    }
}
