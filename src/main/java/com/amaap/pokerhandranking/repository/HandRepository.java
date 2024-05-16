package com.amaap.pokerhandranking.repository;

import java.util.List;

public interface HandRepository {
    void insertIntoHandTable(List<String> cards);
    List<String> getCards();
}
