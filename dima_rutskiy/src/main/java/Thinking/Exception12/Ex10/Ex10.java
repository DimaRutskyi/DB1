package Thinking.Exception12.Ex10;

/**
 * Created by Rrr on 18.05.2016.
 *
 * Create a class with two methods, f( ) and g( ). In g( ), throw an
 exception of a new type that you define. In f( ), call g( ), catch its exception and, in the catch
 clause, throw a different exception (of a second type that you define). Test your code in
 main( ).
 */
public class Ex10 {
    public  void g() throws Exception{
        throw new Exception();
    }

    public void f()throws Exception{
        try{
            g();
        } catch (Exception e) {
            e.printStackTrace();
            throw new OutOfMemoryError();
        }
    }

    public static void main(String[] args) {
        try {
            new Ex10().f();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
