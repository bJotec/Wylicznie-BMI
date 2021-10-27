package pl.camp.it.database;

import java.text.DecimalFormat;

public class BMI extends Database {

    public BMI(double weight, double height, double cal) {
        super(weight, height, cal);
    }

    public static double calculate(double weight, double height){

        double squareHeight = height * height;
        double cal = (weight / squareHeight ) * 10000;

        DecimalFormat df = new DecimalFormat("##.##");
       // To tylko na czas pisania wiadomosc dla mnie
        System.out.println("Twoje BMI wynosi : ");
        System.out.println(df.format(cal));

        return cal;

    }

}
