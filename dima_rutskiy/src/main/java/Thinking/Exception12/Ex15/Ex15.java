package Thinking.Exception12.Ex15;

/**
 * Created by Rrr on 19.05.2016.
 */
class Switch {
    private boolean state = false;
    public boolean read() { return state; }
    public void on() { state = true;System.out.println(this); }
    public void off() { state = false; System.out.println(this); }
    public String toString() { return state ? "on" : "off"; }
}

class OnOffException1 extends Exception {}

class OnOffException2 extends Exception {}

//: exceptions/OnOffSwitch.java
// Why use finally?

public class Ex15 {
    private static Switch sw = new Switch();
    public static void f()
            throws OnOffException1,OnOffException2 {}
    public static void main(String[] args) {
        try {
            sw.on();

            f();

            throw new RuntimeException("runtime ex");
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");

        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");

        }
        finally {
            sw.off();
        }
    }
}
