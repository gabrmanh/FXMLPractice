package com.example.fxmlpractice;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface ConnectionFactory {

    Connection createConnection();

    PreparedStatement createPreparedStatement(String sql);

}
