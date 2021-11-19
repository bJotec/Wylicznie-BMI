package pl.camp.it.database;

import org.apache.commons.codec.digest.DigestUtils;

public class Authenticator {

    public static final String MD5_SEED = "Gd5xAm9OepHO5A1WnYN1IScrSbHgDiRK" ;

    private static final Authenticator instanc = new Authenticator();

    private Authenticator(){
    }

    public static boolean authenticate (String login, String password) {

        Database database = Database.getInstace();
        User user = database.getUserByLogin(login);
        return user != null && user.getPassword().equals(DigestUtils.md5Hex(MD5_SEED + password));

    }

    public static Authenticator getInstanc() {return instanc;}
}
