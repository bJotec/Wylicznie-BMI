package pl.camp.it;

import pl.camp.it.database.BMI;
import pl.camp.it.database.Database;
import pl.camp.it.gui.GUI;
import pl.camp.it.database.Authenticator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Random;

import static pl.camp.it.database.Database.IDBMI;

public class App {
    public static void main(String[] args) throws IOException {


        GUI gui = GUI.getInstance();
        Database database = new Database();
        Authenticator authenticator = Authenticator.getInstanc();

        while (true) {

            gui.showMenu();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String choose = reader.readLine();

            switch (choose) {
                case "1":
                    System.out.println("Wprowadz wage w kilogramach: ");
                    Double weight = Double.valueOf(reader.readLine());
                    System.out.println("Wprowadz wzrost w centrymetrach: ");
                    Double height = Double.valueOf(reader.readLine());

                    Double cal = BMI.calculate(weight, height);

                    Random random = new Random();
                    int id = random.nextInt(101);

                    Database.IDBMI.put(id, new BMI(weight,height,cal));

                    System.out.println(" Twoje unikalne ID pod którym znajduje się BMI to : " + id);

                    break;
                case "2":
                    System.out.println("Zaloguj się aby dowiedziec sie jakie jest Twoje BMI w bazie");
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Login");
                        String login = reader.readLine();
                        System.out.println("Hasło");
                        String password = reader.readLine();

                        if (!authenticator.authenticate(login, password)) {
                            System.out.println("Nieprawidłowe dane");
                        } else {
                            break;
                        }

                        if (i == 2) {
                            return;
                        }
                    }
                    System.out.println();
                    System.out.println("Podaj ID żeby dowiedziec się jakie masz BMI: ");
                    Integer writeID = Integer.valueOf(reader.readLine());

                    if (IDBMI.get(writeID) == null) {
                       System.out.println("Nie ma takiego id");
                   } else {

               System.out.println("Twoje BMI to " + IDBMI.get(writeID).getCal());
               System.out.println("Dla wagi ciała : " + IDBMI.get(writeID).getWeight() + "kg" + " oraz wzrostu : " + IDBMI.get(writeID).getHeight() + "cm");
               System.out.println();
               break;
           }
                    break;

                case "3":
                    System.exit(0);   // 0 to kod błedu który mówi ze nie bylo błędu
                    break;

            }
        }
    }
}
