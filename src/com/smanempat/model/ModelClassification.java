/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smanempat.model;

import com.smanempat.connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Zakaria Andy S
 */
public class ModelClassification {

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

    /*Hasil Transformasi*/
    public int meanUN;
    public int meanPT;
    public int transMinat;

    public int getMeanUN() {
        return meanUN;
    }

    public void setMeanUN(int meanUN) {
        this.meanUN = meanUN;
    }

    public int getMeanPT() {
        return meanPT;
    }

    public void setMeanPT(int meanPT) {
        this.meanPT = meanPT;
    }

    public int getTransMinat() {
        return transMinat;
    }

    public void setTransMinat(int transMinat) {
        this.transMinat = transMinat;
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

    public int getRowCount() {
        int rowCount = 0;
        try {
            DbConnection dbConnection = new DbConnection();
            Connection connect = dbConnection.connect();
            Statement stm = connect.createStatement();
            String query = "SELECT COUNT(*) FROM siswa";
            ResultSet rs = stm.executeQuery(query);
            rowCount = Integer.parseInt(rs.getString(1));
        } catch (Exception e) {
            System.out.println("com.smanempat.model.ModelClassification.getRowCount() " + e);

            e.printStackTrace();
        }
        return rowCount;
    }

    public String[][] getData(int rowCOuntModel) {
        String[][] data = new String[rowCOuntModel][10];
        try {
            DbConnection dbConnection = new DbConnection();
            Connection connect = dbConnection.connect();
            Statement stm = connect.createStatement();
            String query = "SELECT * FROM siswa";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                setNilaiUN("nilai_un");
                setPtBindo("pt_bhs_indonesia");
                setPtMtk("pt_mtk");
                setPtBing("pt_bhs_inggris");
                setPtIpa("pt_ipa");
                setMinat("minat");
                break;
            }
        } catch (Exception e) {

        }
        return data;
    }

}
