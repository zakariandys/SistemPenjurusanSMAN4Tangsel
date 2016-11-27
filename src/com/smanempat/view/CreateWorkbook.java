/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smanempat.view;

import java.io.*;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Zakaria
 */
public class CreateWorkbook {
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create file system using spesific name
        File namaWorkbook = new File("D://WorkBook.xlsx");
        FileOutputStream out = new FileOutputStream(namaWorkbook);
        //Write operation workbook
        workbook.write(out);
        out.close();
        System.out.println("File workbook berhasil dibuat!");
    }
}
