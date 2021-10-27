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

                    double cal = BMI.calculate(weight, height);

                    // *********    tu nie wiem jak wrzucić dane wprowadzone do konstruktora do mapy
                    IDBMI.put(random.nextInt(101), new BMI(weight, height, cal));

                    // *********    tu powinna byc wyplute ID tylko tego wyliczonego a nie wszystkie ktore generowane bylo pokolei ??
                    System.out.println(" Twoje unikalne ID pod którym znajduje się BMI to : " + IDBMI.keySet());

                    break;
                case "2":
                    System.out.println("Podaj ID żeby dowiedziec się jakie masz BMI: ");
                    Integer writeID = Integer.valueOf(reader.readLine());

                    for (int element : IDBMI.keySet()) {
                        if (element == writeID) {
                            // *********    tu Nie wiem jak wypluć tylko zmienną "cal" odpowiedzialną za BMI, a potem wypluć wprowadzone dane czyli wysokość i wage
                            System.out.println("Twoje BMI to " + IDBMI.values() + " Dla podanych danych :" + " tu dodac  getery do podanych wysokosci i mas");
                            break;
                        } else  {
                            System.out.println("NIE MA TAKIEGO ID!!! ");
                        }
                    }
                    break;

                case "3":
                    System.exit(0);   // 0 to kod błedu który mówi ze nie bylo błędu
                    break;

            }
        }
    }
}
