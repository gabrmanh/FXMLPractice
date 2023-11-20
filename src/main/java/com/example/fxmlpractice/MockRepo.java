package com.example.fxmlpractice;

import java.util.ArrayList;
import java.util.List;

public class MockRepo implements ProductRepository
{

    public List<Product> products = List.of(
            new Product("Reimu doll", 5000.00, 4),
            new Product("Marisa plush", 3000.00, 9),
            new Product("PC98 Reimu", 10000.00, 2)
    );

    @Override
    public List<Product> findAll() {
        return products;
    }

    public void update(List<Product> list){
        products = list;
    }
}
