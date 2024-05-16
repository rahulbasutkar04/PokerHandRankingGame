package com.amaap.pokerhandranking.repository.impl.db;

import java.util.List;

public interface FakeDatabase {
    void insertIntoHandTable(List<String> cards);

    List<String> getCards();
}
