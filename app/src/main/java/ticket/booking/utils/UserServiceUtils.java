package ticket.booking.utils;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtils {

    public UserServiceUtils() {}

    public String getHashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
