/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smanempat.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Zakaria Andy S
 */
public class DbConnection {

    private static Connection conn = null;
    private static String url = null;

//    public static void main(String[] args) {
//        //connect();
//        //simpan();
//    }
    public Connection connect() throws SQLException {

//        url = "jdbc:sqlite:" + getClass().getResource("db/sman4db.db");
        url = "jdbc:sqlite:db/sman4db.db";
        conn = DriverManager.getConnection(url);
        try {
            if (conn == null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

//    private static void simpan() {
//        String sql = "INSERT INTO Mahasiswa(nim,nama, nilai) VALUES(?,?,?)";
//        DbConnection obj = new DbConnection();
//        try (Connection conn = obj.connect();
//                PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, nim);
//            pstmt.setString(2, nama);
//            pstmt.setString(3, nilai);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
