package Thinking.Exception12.Ex21;

/**
 * Created by Rrr on 01.06.2016.
 *  Demonstrate that a derived-class constructor cannot catch exceptions
 thrown by its base-class constructor
 */

 class BaseException extends Exception{}
class  Base {
    Base() throws BaseException{
        throw new BaseException();
    }
}

class Derived extends Base{
    Derived() throws BaseException{
        super();
       /* try {

    } catch(BaseException e) {}*/
    }
}
public class Ex21 {
    public static void main(String[] args) {
       try {
           Derived d = new Derived();
       }catch (BaseException e){
           System.out.println("BaseException");
       }
    }

}
