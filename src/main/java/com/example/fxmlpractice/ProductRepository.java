package com.example.fxmlpractice;

import javafx.collections.ObservableList;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findOne(int id);
    void add(Product p);
    void update(Product p);
    void remove(int id);
}
