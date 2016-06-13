package Thinking.Exception12.Ex13;

/**
 * Created by Rrr on 18.05.2016.
 *  Modify Exercise 9 by adding a finally clause. Verify that your finally
 clause is executed, even if a NullPointerException is thrown
 */

class MyException extends Exception{
    MyException(String s){
        String str;
        str=s;
        System.out.println(s);
    }
}
class MyException2 extends Exception{
    MyException2(String s){
        String str;
        str=s;
        System.out.println(s);
    }
}
class MyException3 extends Exception{
    MyException3(String s){
        String str;
        str=s;
        System.out.println(s);
    }
}
public class Ex13 {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException("hello");
    }

    public static void d() throws MyException2 {
        System.out.println("Throwing MyException2 from f()");
        throw new MyException2("hello2");
    }

    public static void r() throws MyException3 {
        System.out.println("Throwing MyException3 from f()");
        throw new MyException3("hello3");
    }

    public static void main(String[] args) {
        Ex13 ex = new Ex13();
        try {
            ex.f();
            ex.d();
            ex.r();
        } catch (Exception e) {
            System.out.println("All exception are cached");
            e.printStackTrace(System.out);
        }
        finally {
            System.out.println("finally block");
        }
    }
}