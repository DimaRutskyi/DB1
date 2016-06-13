package Thinking.Exception12.Ex4;
//Create your own exception class using the extends keyword. Write a
//        constructor for this class that takes a String argument and stores it inside the object with a
//        String reference. Write a method that displays the stored String. Create a try-catch clause
//        to exercise your new exception.
/**
 * Created by Rrr on 14.03.2016.
 */

 class MyException extends Exception{
   MyException(String s){
       String str;
       str=s;
       System.out.println(s);
   }
}
public class Ex4 {
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
