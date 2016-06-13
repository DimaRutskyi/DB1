package Thinking.Exception12.Ex18;

/**
 * Created by Rrr on 20.05.2016.
 * Add a second level of exception loss to LostMessage.java so that the
 HoHumException is itself replaced by a third exception.
 */
class VeryImportantException extends Exception {
    public String toString() {

        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}
class HoHumException2 extends Exception {
    public String toString() {
        return "A super trivial exception";
    }
}
public class Ex18 {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void g() throws HoHumException {
        throw new HoHumException();}

    void dispose() throws HoHumException2 {
        throw new HoHumException2();
    }
    public static void main(String[] args) {
        try {
            Ex18 lm = new Ex18();
            try {
                lm.f();
                lm.g();
            } finally {
                lm.dispose();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
