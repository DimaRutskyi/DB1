package Thinking.Exception12.Ex7;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by Rrr on 13.05.2016.
 *
 * Modify Exercise 3 so that the catch clause logs the results.
 */
public class Ex7 {

    public void f() throws ArrayIndexOutOfBoundsException{
    int [] a= {1,2,3};
    a[4]=5;

}
    private static Logger logger=Logger.getLogger("LoggingException");
    static void LogException(Exception e){
        StringWriter trace=new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        try{
            Ex7 ex=new Ex7();
            ex.f();

        }
        catch (ArrayIndexOutOfBoundsException e){ e.printStackTrace();LogException(e);
        }
    }
}