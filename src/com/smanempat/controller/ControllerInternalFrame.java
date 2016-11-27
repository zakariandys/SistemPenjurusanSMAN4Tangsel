/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smanempat.controller;

import com.smanempat.view.NewJInternalFrame;
import com.smanempat.model.ModelInternalFrame;
import com.toedter.calendar.JYearChooser;

/**
 *
 * @author Zakaria Andy S
 */
public class ControllerInternalFrame {

    public NewJInternalFrame internalFrame;
    public ModelInternalFrame modelInternalFrame;
    String nim, nama, nilai;

    public void importToDatabase(int rowValue, int columnValue, String[][] data, JYearChooser thnAjaran1, JYearChooser thnAjaran2) {
        internalFrame = new NewJInternalFrame();
        modelInternalFrame = new ModelInternalFrame();
        System.out.println(data[0][0]);
        String tahunAjaran = Integer.toString(thnAjaran1.getYear()) + "/" + Integer.toString(thnAjaran2.getYear());
        for (int b = 1; b < rowValue; b++) {
            int c = 0;
            while (c < columnValue) {
                nim = data[b][c];
                nama = data[b][c + 1];
                nilai = data[b][c + 2];
                break;
            }
            modelInternalFrame.setNim(nim);
            modelInternalFrame.setNama(nama);
            modelInternalFrame.setNilai(nilai);
            modelInternalFrame.setTahun(tahunAjaran);

            System.out.println(nim + ", " + nama + ", " + nilai + "," + tahunAjaran);
            modelInternalFrame.importToDatabase();
        }

    }

}
