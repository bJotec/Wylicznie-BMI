package pl.camp.it.database;

import java.text.DecimalFormat;

public class BMI extends Database {

    private double cal;

    public BMI(double weight, double height, double cal) {
        super(weight, height);
        this.cal = cal;
    }

    public static double calculate(double weight, double height){

        double squareHeight = height * height;
        double cal = (weight / squareHeight ) * 10000;

        DecimalFormat df = new DecimalFormat("##.##");

       /* System.out.println("Twoje BMI wynosi : ");
        System.out.println(df.format(cal));*/

        return cal;

    }
    public String getCal() {
        DecimalFormat df = new DecimalFormat("##.##");
        return df.format(cal);}

}
