/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smanempat.controller;

/**
 *
 * @author Zakaria Andy S
 */
public class Modulus {

    public static void main(String[] args) {
        int a = 974;
        int b = 4;
//        double c = a % b;
//        System.out.println(c);
        double pow = Math.pow(b, 2);
        double sqrt = Math.sqrt(pow);
        System.out.println("Hasil Math.pow " + pow);
        System.out.println("Hasil Math.sqrt " + sqrt);
    }

}
