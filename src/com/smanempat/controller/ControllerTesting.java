/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smanempat.controller;

import com.smanempat.view.ComboBoxWithCheckBox;
import com.smanempat.model.ModelTesting;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zakaria Andy S
 */
public class ControllerTesting {

    public String tableContent;

    public ModelTesting modelTesting = new ModelTesting();
    public DefaultTableModel tableModel;

    public void showTahunAjaran(JTable tableTahun) {
        tableModel = (DefaultTableModel) tableTahun.getModel();

        modelTesting.showTahunAjaran();
        for (int i = 0; i < modelTesting.getTahunAjaran().size(); i++) {
            System.out.println(modelTesting.getTahunAjaran().get(i));
            tableModel.addRow(new Object[]{
                modelTesting.getTahunAjaran().get(i), false
            });
        }
        tableTahun.setModel(tableModel);
    }

}
