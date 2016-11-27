
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zakaria Andy S
 */
public class ContohDecimalFormat {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000000");
        double a = 0;

        System.out.println(df.format(a));
    }

}
