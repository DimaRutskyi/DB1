package hw3.chat;

import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by s_okhoda on 05.01.2016.
 */
public class etse {
    public static void main(String[] args){
        Random rnd = new Random();
        String s = "ddf1";
        System.out.println(s);
        s = s.replaceAll("\\d","2");
        System.out.println(s);
        System.out.println( String.valueOf((char)(19)));
        Character c= new Character ((char)(55));
        String Delimiter = String.valueOf((char)(19));
        String s2 = Delimiter + "Client2";
        System.out.println(s2.indexOf(Delimiter));
        System.out.println(s2.split(Delimiter)[0]);//+ "\n" + s2.split
        // (Delimiter)[1]) ;
//                        Integer.toString(rnd.nextInt())));
    }
}
