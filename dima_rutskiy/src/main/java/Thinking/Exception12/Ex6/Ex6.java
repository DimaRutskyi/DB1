package Thinking.Exception12.Ex6;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by Rrr on 12.05.2016.
 *
 *  Create two exception classes, each of which performs its own logging
 automatically. Demonstrate that these work.
 */
class LoggingException extends Exception{
    private static Logger logger=Logger.getLogger("LoggingException");
    public LoggingException(){
        StringWriter trace=new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
class LoggingException2 extends Exception{
    private static Logger logger=Logger.getLogger("LoggingException number2");
    public LoggingException2(){
        StringWriter trace=new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
public class Ex6 {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e){
            System.err.println("Perechvacheno"+e);
        }
        try {
            throw new LoggingException2();
        } catch (LoggingException2 e){
            System.err.println("Perechvacheno"+e);
        }
    }
}
