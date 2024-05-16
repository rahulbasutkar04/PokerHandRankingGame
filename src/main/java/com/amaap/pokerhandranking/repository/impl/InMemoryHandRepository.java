package com.amaap.pokerhandranking.repository.impl;

import com.amaap.pokerhandranking.repository.HandRepository;
import com.amaap.pokerhandranking.repository.impl.db.impl.InMemoryFakeDatabase;

import java.util.List;

public class InMemoryHandRepository implements HandRepository {

    private static InMemoryHandRepository instance;
    private InMemoryFakeDatabase inMemoryFakeDatabase=InMemoryFakeDatabase.getInstance();

    private InMemoryHandRepository(){

    }

    public  static  synchronized InMemoryHandRepository getInstance(){
        if(instance==null){
            instance=new InMemoryHandRepository();
        }

        return instance;
    }
    @Override
    public void insertIntoHandTable(List<String> cards) {
        inMemoryFakeDatabase.insertIntoHandTable(cards);
    }

    @Override
    public List<String> getCards() {
     return inMemoryFakeDatabase.getCards();
    }

    public void clear()
    {
        inMemoryFakeDatabase.clearStorage();
    }
}
