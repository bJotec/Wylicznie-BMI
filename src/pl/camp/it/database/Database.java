package pl.camp.it.database;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import pl.camp.it.database.*;

public class Database  {

    public static Map<Integer, BMI> IDBMI = new HashMap<>();
    public static List<User> users = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static Random random = new Random();
    static int id = random.nextInt(101);

    private static final Database instace = new Database();


    public Database () {

        double weight = 0;
        double height =0 ;
        double cal = 0;

        IDBMI.put(id, new BMI(weight, height, cal));
        this.users.add(new User("admin", DigestUtils.md5Hex(Authenticator.MD5_SEED + "admin")));
        this.users.add(new User("user",DigestUtils.md5Hex(Authenticator.MD5_SEED + "user")));
    }

    public User getUserByLogin (String login) {
        for (User user:this.users){
            if ( user.getLogin().equals(login)){
                return user;
            }
        }

        return  null;
    }


    public static Database getInstace() {
        return instace;
    }
}
