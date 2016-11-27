/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smanempat.model;

import com.smanempat.connection.DbConnection;
import com.smanempat.controller.ControllerEvaluation;
import com.smanempat.controller.ControllerTesting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zakaria Andy S
 */
public class ModelEvaluation {

    public ArrayList<String> tahunAjaran;
    public ControllerEvaluation controllerEvaluation;
    public DbConnection dbConnection;

    public String query;
    public ArrayList<String> tableContent;
    public Connection connect;
    public Statement stm;
    public ResultSet rs;
    public PreparedStatement pstmt;

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

    public ArrayList<String> getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(ArrayList<String> tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }

    public void selectTahunAjaran() {
        try {
            controllerEvaluation = new ControllerEvaluation();
            tahunAjaran = new ArrayList<>();
            dbConnection = new DbConnection();
            connect = dbConnection.connect();
            stm = connect.createStatement();
//            query = "SELECT * FROM tahun";
            query = "SELECT tahun_ajaran FROM siswa GROUP BY tahun_ajaran";
            rs = stm.executeQuery(query);
            while (rs.next()) {
                tahunAjaran.add(rs.getString("tahun_ajaran"));
                //setTahunAjaran(tahunAjaran);
                /*Remark!!*/
            }
//            rs.close();
//            stm.close();
//            connect.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void showDataSetModel(String tempArrayList) throws SQLException {

        /*Tanpa setter method*/
        controllerEvaluation = new ControllerEvaluation();
        dbConnection = new DbConnection();
        connect = dbConnection.connect();

        //stm = connect.createStatement();
        query = "SELECT * FROM siswa WHERE tahun_ajaran = ?";
        pstmt = connect.prepareStatement(query);
        pstmt.setString(1, tempArrayList.toString());
        rs = pstmt.executeQuery();
        while (rs.next()) {
            setNis(rs.getString("nis"));
            setNama(rs.getString("nama"));
            setJenisKelamin(rs.getString("jenis_kelamin"));
            setNilaiUN(rs.getString("nilai_un"));
            setPtBindo(rs.getString("pt_bhs_indonesia"));
            setPtMtk(rs.getString("pt_matematika"));
            setPtBing(rs.getString("pt_bhs_inggris"));
            setPtIpa(rs.getString("pt_ipa"));
            setMinat(rs.getString("minat"));
            setJurusan(rs.getString("jurusan"));
            break;
        }
    }

}
