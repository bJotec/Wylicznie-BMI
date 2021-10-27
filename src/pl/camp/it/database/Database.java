package pl.camp.it.database;

public class Database {

    double weight ;
    double height ;
    public double cal;
    double bmi2;

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getCal() {return cal;}

    public Database(double weight, double height, double cal) {
        this.weight = weight;
        this.height = height;
        this.cal = cal;
    }

}
