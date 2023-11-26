package com.example.fxmlpractice;

public class Principal {
    public static void main(String[] args) {
        Product product = new Product(0,"new", 333.00, 111);
        SQLiteRepository sqLiteRepository = new SQLiteRepository();

        sqLiteRepository.remove(0);
        System.out.println(sqLiteRepository.findAll());
    }
}
