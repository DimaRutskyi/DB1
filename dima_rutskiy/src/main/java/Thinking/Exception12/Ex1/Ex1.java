package Thinking.Exception12.Ex1;

/**
 * Created by Rrr on 09.03.2016.
 */
class MyException extends Exception{
    MyException(String s){}

}
public class Ex1 {
    public void f(String s) throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException(s);
    }

    public static void main(String[] args) {
        Ex1 ex=new Ex1();
        try {
            ex.f("string");
        }
        catch (MyException e){
            e.printStackTrace(System.out);
        }
    }
}
