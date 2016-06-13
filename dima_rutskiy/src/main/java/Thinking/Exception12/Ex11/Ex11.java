package Thinking.Exception12.Ex11;

/**
 * Created by Rrr on 18.05.2016.
 *
 *  Repeat the previous exercise, but inside the catch clause, wrap g( )’s
 exception in a RuntimeException
 */
public class Ex11 {
    public  void g() throws Exception{
        throw new Exception();
    }

    public void f()throws RuntimeException{
        try{
            g();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
       // try {
            new Ex11().f();
//        }catch (Exception e) {
//            e.printStackTrace();
       // }
    }
}
