package pl.camp.it.database;

import java.text.DecimalFormat;

public class BMI {

    /*private static final BMI instance = new BMI();*/


    public BMI(double weight, double height, double cal) {
        this.cal = cal;
        this.weight = weight;
        this.height = height;
    }
    double weight ;
    double height ;
    double cal ;

    public static double calculate(double weight, double height){

        double squareHeight = height * height;
        double cal = (weight / squareHeight ) * 10000;

        DecimalFormat df = new DecimalFormat("##.##");

        System.out.println("Twoje BMI wynosi : ");
        System.out.println(df.format(cal));

        return cal;

    }
    public String getCal() {
        DecimalFormat df = new DecimalFormat("##.##");
        return df.format(cal);}

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

/*    public static BMI getInstance(){
        return instance;
    }*/
}
