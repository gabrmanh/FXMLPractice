package com.example.fxmlpractice;

import javafx.collections.ObservableList;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void update(List<Product> List);
}
