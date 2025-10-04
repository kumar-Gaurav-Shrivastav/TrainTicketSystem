package ticket.booking.utils;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtils {

    public UserServiceUtils() {}

    public static String getHashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
