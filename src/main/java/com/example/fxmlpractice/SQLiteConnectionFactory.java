package com.example.fxmlpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteConnectionFactory implements AutoCloseable, ConnectionFactory{
    private Connection connection;
    private PreparedStatement preparedStatement;

    @Override
    public Connection createConnection() {
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/fxmlpractice/products.db");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public PreparedStatement createPreparedStatement(String sql) {
        try{
            preparedStatement = createConnection().prepareStatement(sql);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public void close() throws Exception {
        if(connection != null){
            if(preparedStatement != null) preparedStatement.close();
            connection.close();
        }
    }
}
