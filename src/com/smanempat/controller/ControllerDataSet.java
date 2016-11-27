/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smanempat.controller;

import com.smanempat.model.ModelDataSet;
import com.smanempat.model.ModelInternalFrame;
import com.smanempat.view.ViewDialogDataset;

import com.toedter.calendar.JYearChooser;
import java.awt.Cursor;
import java.sql.SQLException;
import javafx.scene.text.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zakaria Andy S
 */
public class ControllerDataSet {

    public ModelDataSet modelDataSet = new ModelDataSet();
    boolean yes;

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

    public void importToDatabase(int rowValue, int columnValue, String[][] data, JYearChooser thnAjaran1, JYearChooser thnAjaran2, DefaultTableModel tableModel, int countOutlier, JLabel lableAllData) throws SQLException {
        tahunAjaran = Integer.toString(thnAjaran1.getYear()) + "/" + Integer.toString(thnAjaran2.getYear());
        modelDataSet.setTahunAjaran(tahunAjaran);
        boolean cekTahun = modelDataSet.cekTahunAjaran();
        if (cekTahun == true) {
            JOptionPane.showMessageDialog(null, "Tahun Ajaran " + thnAjaran1.getYear() + "/" + thnAjaran2.getYear() + " sudah ada, periksa Tahun Ajaran!", "Peringatan", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/com/smanempat/image/fail.png"));
        } else {
            int rowData = tableModel.getRowCount();
            for (int i = 1; i < rowValue; i++) {
                yes = false;
                int j = 0;
                while (j < columnValue) {
                    nis = data[i][j];
                    nama = data[i][j + 1];
                    jenisKelamin = data[i][j + 2];
                    nilaiUN = data[i][j + 3];
                    ptBindo = data[i][j + 4];
                    ptMtk = data[i][j + 5];
                    ptBing = data[i][j + 6];
                    ptIpa = data[i][j + 7];
                    minat = data[i][j + 8];
                    jurusan = data[i][j + 9];
                    /*Pre-Processing*/
                    cleansingData(tableModel, i);
                    break;
                }
                if (yes == false) {
                    modelDataSet.setNis(nis);
                    modelDataSet.setNama(nama);
                    modelDataSet.setJenisKelamin(jenisKelamin);
                    modelDataSet.setNilaiUN(nilaiUN);
                    modelDataSet.setPtBindo(ptBindo);
                    modelDataSet.setPtMtk(ptMtk);
                    modelDataSet.setPtBing(ptBing);
                    modelDataSet.setPtIpa(ptIpa);
                    modelDataSet.setMinat(minat);
                    modelDataSet.setJurusan(jurusan);
                    modelDataSet.saveDataNilai();

                }
            }

//            modelDataSet.setJumlahData(((rowValue - 1) - countOutlier));
//            modelDataSet.saveTahunAjaran();
            lableAllData.setText(countTotalData() + " Data");
            JOptionPane.showMessageDialog(null, "Berhasil Meng-Import Dataset.\n\n"
                    + "Informasi :\n"
                    + "- " + ((rowValue - 1) - countOutlier) + " Data\n"
                    + "- " + countOutlier + " Outlier", "Sukses", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/com/smanempat/image/success.png"));

        }

    }

    public void cleansingData(DefaultTableModel tableModel, int i) {
        double tempNilaiUN;
        double tempPtBindo;
        double tempPtMtk;
        double tempPtBing;
        double tempPtIpa;
        tempNilaiUN = Double.parseDouble(nilaiUN);
        tempPtBindo = Double.parseDouble(ptBindo);
        tempPtMtk = Double.parseDouble(ptMtk);
        tempPtBing = Double.parseDouble(ptBing);
        tempPtIpa = Double.parseDouble(ptIpa);
        if (tempNilaiUN == 0.0 || tempPtBindo == 0.0 || tempPtMtk == 0.0 || tempPtBing == 0.0 || tempPtIpa == 0.0) {
            //tableModel.removeRow(i);
            yes = true;
        }
        //return yes;
    }

    public void checkAnomaliData() {
        double tempNilaiUN;
        double tempPtBindo;
        double tempPtMtk;
        double tempPtBing;
        double tempPtIpa;
        tempNilaiUN = Double.parseDouble(nilaiUN);
        tempPtBindo = Double.parseDouble(ptBindo);
        tempPtMtk = Double.parseDouble(ptMtk);
        tempPtBing = Double.parseDouble(ptBing);
        tempPtIpa = Double.parseDouble(ptIpa);
        if (tempNilaiUN == 0.0 || tempPtBindo == 0.0 || tempPtMtk == 0.0 || tempPtBing == 0.0 || tempPtIpa == 0.0) {
//            tableModel.removeRow(i);
            yes = true;
        }
    }

    public int countTotalData() {
        int totalData;
        modelDataSet = new ModelDataSet();
        totalData = modelDataSet.selectTotalData();
        return totalData;
    }

}
