package Thinking.Exception12.Ex22;

import java.io.IOException;

/**
 * Created by Rrr on 01.06.2016.
 *
 * Create a class called FailingConstructor with a constructor that
 might fail partway through the construction process and throw an exception. In main( ),
 write code that properly guards against this failure.
 */

class ConstructionException extends Exception {}

class FailingConst  {
    // Construction can fail:
    public FailingConst() throws ConstructionException {}
}

public class Ex22 {
    public static void main(String[] args) {


        // Section 3:
        // If construction can fail you must guard each one:
        try {
            FailingConst nc4 = new FailingConst();


        } catch(ConstructionException e) { // nc4 constructor
            System.out.println(e);
        }finally {

        }
    }
}