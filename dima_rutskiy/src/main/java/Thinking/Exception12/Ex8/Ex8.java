package Thinking.Exception12.Ex8;



/**
 * Created by Rrr on 13.05.2016.
 *
 *  Write a class with a method that throws an exception of the type created
 in Exercise 4. Try compiling it without an exception specification to see what the compiler
 says. Add the appropriate exception specification. Try out your class and its exception inside
 a try-catch clause.
 */
class MyException extends Exception{
    MyException(String s){
        String str;
        str=s;
        System.out.println(s);
    }
}
public class Ex8 {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException("hello");
    }
    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
