package session2;

/**
 * Created by Home on 20.12.2015.
 */
public class User implements Comparable<User>{

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User(String login, String password) {
            setLogin(login);
            setPassword(password);
    }

    @Override
    public String toString() {
        return this.getPassword();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public int compareTo(User user){
        return user.getPassword().length() - this.password.length();
    }
}

