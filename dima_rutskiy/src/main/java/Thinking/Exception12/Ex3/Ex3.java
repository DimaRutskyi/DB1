package Thinking.Exception12.Ex3;

/**
 * Created by Rrr on 09.03.2016.
 */
public class Ex3 {
    public void f() throws ArrayIndexOutOfBoundsException{
    int [] a= {1,2,3};
        a[4]=5;
    }

    public static void main(String[] args) {
        try{
        new Ex3().f();}
        catch (ArrayIndexOutOfBoundsException e){e.printStackTrace(System.out);
        }
    }
}
