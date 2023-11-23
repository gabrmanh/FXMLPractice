package com.example.fxmlpractice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ProductManagerController {
    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product, String> productColumn;
    @FXML private TableColumn<Product, Double> priceColumn;
    @FXML private TableColumn<Product, Integer> quantityColumn;

    @FXML private TextField productInput;
    @FXML private TextField priceInput;
    @FXML private TextField quantityInput;

    private ObservableList<Product> observableList;
    private ProductRepository repo = new SQLiteRepository();

    public void bindColumnsToProperties(){
        productColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    public void bindSourceToTable(){
        observableList = FXCollections.observableArrayList();
        productTable.setItems(observableList);
    }

    private void loadInitialData(){
        List<Product> products = repo.findAll();
        observableList.clear();
        observableList.addAll(products);
    }

    @FXML
    private void initialize(){
        bindColumnsToProperties();
        bindSourceToTable();
        loadInitialData();
    }

    public void add(){
        try {
            if (productInput.getText().isEmpty())
                throw new InvalidInputException("Product Name may not be null.");
            if (priceInput.getText().isEmpty())
                throw new InvalidInputException("Product Price may not be null.");
            if (quantityInput.getText().isEmpty())
                throw new InvalidInputException("Product Quantity may not be null.");

            double price = Double.parseDouble(priceInput.getText());
            int quantity = Integer.parseInt(quantityInput.getText());

            System.out.println(observableList.size());
            System.out.println("-");
            Product p = new Product(observableList.size()+1,productInput.getText(), price, quantity);
            System.out.println(observableList.size());

            observableList.add(p);
            repo.add(p);
        } catch (Exception e){
            InputErrorView inputErrorView = new InputErrorView();
            inputErrorView.show(e);
        }
    }

    public void update(){
        //use mouse to get index, use index to get product, open new window to update it
        //pain
        //or not man he wants it to be done by clicked product?? what the fuck ever
    }

    public void delete() {
        try {
            int index = productTable.getSelectionModel().getSelectedIndex();
            observableList.remove(index);
            repo.remove(index+1); //this is so fucked up lmao
        } catch (Exception e){
            InputErrorView inputErrorView = new InputErrorView();
            inputErrorView.show(e);
        }
    }

    public void clear(){
        productInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }



}