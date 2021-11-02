package pl.camp.it;

import pl.camp.it.database.BMI;
import pl.camp.it.gui.GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class App {
    public static void main(String[] args) throws IOException {

        Random random = new Random();
        Map<Integer, BMI> IDBMI = new HashMap<>();


        while (true) {

            GUI.showMenu();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String choose = reader.readLine();

            switch (choose) {
                case "1":
                    System.out.println("Wprowadz wage w kilogramach: ");
                    Double weight = Double.valueOf(reader.readLine());
                    System.out.println("Wprowadz wzrost w centrymetrach: ");
                    Double height = Double.valueOf(reader.readLine());

                    Double cal = BMI.calculate(weight, height);

                    int id = random.nextInt(101);

                    IDBMI.put(id, new BMI(weight, height, cal));

                    System.out.println(" Twoje unikalne ID pod którym znajduje się BMI to : " + id);

                    break;
                case "2":
                    System.out.println("Podaj ID żeby dowiedziec się jakie masz BMI: ");
                    Integer writeID = Integer.valueOf(reader.readLine());
// ********************** próba na ifie niedziałająca
                    if (writeID != IDBMI.get(writeID).keySet()) {
                        System.out.println("nie ma takiego id");
                    } else {
                        System.out.println("Twoje BMI to " + IDBMI.get(writeID).getCal());
                        System.out.println("dla wagi ciała : " + IDBMI.get(writeID).getWeight() + "kg" + " oraz wzrostu : " + IDBMI.get(writeID).getHeight() + "cm");
                        System.out.println("oraz wzrostu : " + IDBMI.get(writeID).getHeight() + "cm");
                    }

                    break;

                case "3":
                    System.exit(0);   // 0 to kod błedu który mówi ze nie bylo błędu
                    break;

            }
        }
    }
}
