package session2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.12.15
 */
public class Auth {
    private Set<User> users = new HashSet<>();

    public static void main(String[] args) {
        Auth auth = new Auth();
        boolean isPresent = auth.isAuthenticated("Piter", "Pershii");
        System.out.println("PiterII present: " + isPresent);
    }
    public Auth() {
        users.add(new User("Piter", "Pershii"));
        users.add(new User("Viktor", "Pershii"));
        users.add(new User("Yulia", "Pershaya"));
    }

    public boolean isAuthenticated(String login, String pass) {
     for (User user : users) {
            if(user.getLogin().equals(login) && user.getPass().equals(pass)) {
                return true;
            }
        }
        return false;
       // return users.contains(new User(login, pass));
    }
}
