package pl.camp.it.gui;

public class GUI {

    private static final GUI instance = new GUI();

    private GUI() {

    }

    public static void showMenu () {

        System.out.println("1. Wylicz BMI ");
        System.out.println("2. Wczytaj BMI ");
        System.out.println("3. Wyjscie ");
    }
    public static GUI getInstance(){
        return instance;
    }
}
