package com.example.fxmlpractice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteRepository implements ProductRepository{

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/fxmlpractice/products.db");
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                list.add(new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getDouble("price"), rs.getInt("quantity")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findOne(int id) {
        Product p = null;
        String sql = "SELECT * FROM product WHERE id = ?";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/fxmlpractice/products.db");
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                p = new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getDouble("price"), rs.getInt("quantity"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void add(Product p) {
        String sql = "INSERT INTO product (id, name, price, quantity) values (?,?,?,?)";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/fxmlpractice/products.db");
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getName());
            stmt.setDouble(3, p.getPrice());
            stmt.setInt(4, p.getQuantity());

            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product p) {
        String sql = "UPDATE product SET name = ?, price = ?, quantity = ? WHERE id = ?";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/fxmlpractice/products.db");
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, p.getName());
            stmt.setDouble(2, p.getPrice());
            stmt.setInt(3, p.getQuantity());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM product WHERE id = ?";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/fxmlpractice/products.db");
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
