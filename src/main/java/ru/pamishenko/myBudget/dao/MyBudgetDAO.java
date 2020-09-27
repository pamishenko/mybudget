package ru.pamishenko.myBudget.dao;

import java.util.List;

public interface ArticleDAO<T> {
    List<T> 
    void create();
    void read();
    void update();
    void delete();
}
