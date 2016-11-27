/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smanempat.model;

import com.smanempat.connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Zakaria Andy S
 */
public class ModelDataSet {

    public String nis;
    public String nama;
    public String jenisKelamin;
    public String nilaiUN;
    public String ptBindo;
    public String ptMtk;
    public String ptBing;
    public String ptIpa;
    public String minat;
    public String jurusan;
    public String tahunAjaran;
    public int jumlahData;
//    private boolean cekTahun;
    private String query;

    public Connection connection;
    public DbConnection dbConnection = new DbConnection();
    public PreparedStatement preparedStatement;
    public Statement statement;
    public ResultSet resultSet;

    public int getJumlahData() {
        return jumlahData;
    }

    public void setJumlahData(int jumlahData) {
        this.jumlahData = jumlahData;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNilaiUN() {
        return nilaiUN;
    }

    public void setNilaiUN(String nilaiUN) {
        this.nilaiUN = nilaiUN;
    }

    public String getPtBindo() {
        return ptBindo;
    }

    public void setPtBindo(String ptBindo) {
        this.ptBindo = ptBindo;
    }

    public String getPtMtk() {
        return ptMtk;
    }

    public void setPtMtk(String ptMtk) {
        this.ptMtk = ptMtk;
    }

    public String getPtBing() {
        return ptBing;
    }

    public void setPtBing(String ptBing) {
        this.ptBing = ptBing;
    }

    public String getPtIpa() {
        return ptIpa;
    }

    public void setPtIpa(String ptIpa) {
        this.ptIpa = ptIpa;
    }

    public String getMinat() {
        return minat;
    }

    public void setMinat(String minat) {
        this.minat = minat;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }

    public void saveTahunAjaran() {
        String tempTahun;
        boolean cekTahun = false;
        try {
            connection = dbConnection.connect();
            statement = connection.createStatement();
            query = "SELECT tahun_ajaran FROM siswa GROUP BY tahun_ajaran";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                tempTahun = resultSet.getString("tahun_ajaran");
                if (tempTahun.equals(tahunAjaran)) {
                    cekTahun = true;
                    break;
                }
            }
//            resultSet.close();
//            statement.close();
//            connection.close();

//            if (cekTahun == false) {
//                query = "INSERT INTO tahun(tahun_ajaran, jumlah_data)"
//                        + "VALUES (?, ?)";
//                preparedStatement = connection.prepareStatement(query);
//                preparedStatement.setString(1, getTahunAjaran());
//                preparedStatement.setInt(2, getJumlahData());
//                preparedStatement.executeUpdate();
//            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("com.smanempat.model.ModelDataSet.saveTahunAjaran()\n " + e);
        }
    }

    public void saveDataNilai() {
        try {
            connection = dbConnection.connect();
            query = "INSERT INTO siswa(tahun_ajaran, nis, nama, jenis_kelamin, nilai_un, pt_bhs_indonesia, pt_matematika, pt_bhs_inggris, pt_ipa, minat, jurusan) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, getTahunAjaran());
            preparedStatement.setString(2, getNis());
            preparedStatement.setString(3, getNama());
            preparedStatement.setString(4, getJenisKelamin());
            preparedStatement.setString(5, getNilaiUN());
            preparedStatement.setString(6, getPtBindo());
            preparedStatement.setString(7, getPtMtk());
            preparedStatement.setString(8, getPtBing());
            preparedStatement.setString(9, getPtIpa());
            preparedStatement.setString(10, getMinat());
            preparedStatement.setString(11, getJurusan());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("com.smanempat.model.ModelDataSet.saveDataNilai()\n " + e);
        }
    }

    public int selectTotalData() {
        int totalData = 0;
        try {
            dbConnection = new DbConnection();
            connection = dbConnection.connect();
            query = "SELECT COUNT(*) AS total_data FROM siswa";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                totalData = resultSet.getInt("total_data");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalData;
    }

    public boolean cekTahunAjaran() throws SQLException {
        String tempTahun;
        boolean cekTahun = false;
        try {
            connection = dbConnection.connect();
            statement = connection.createStatement();
            query = "SELECT tahun_ajaran FROM siswa GROUP BY tahun_ajaran";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                tempTahun = resultSet.getString("tahun_ajaran");
                if (tempTahun.equals(tahunAjaran)) {
                    cekTahun = true;
                    break;
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("com.smanempat.model.ModelDataSet.saveTahunAjaran()\n " + e);
        }
        return cekTahun;
    }

}
