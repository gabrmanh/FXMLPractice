package com.example.fxmlpractice;

import java.util.ArrayList;
import java.util.List;

public class MockRepo implements ProductRepository {

    public List<Product> products = List.of(
            new Product(1, "Reimu doll", 5000.00, 4),
            new Product(2, "Marisa plush", 3000.00, 9),
            new Product(3, "PC98 Reimu", 10000.00, 2)
    );

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findOne(int Id) {
        return null;
    }

    @Override
    public void add(Product p) {

    }

    @Override
    public void update(Product p) {

    }

    @Override
    public void remove(int Id) {

    }
}