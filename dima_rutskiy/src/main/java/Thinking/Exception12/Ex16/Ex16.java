package Thinking.Exception12.Ex16;

/**
 * Created by Rrr on 20.05.2016.
 *  Modify reusing/CADSystem.java to demonstrate that returning
 from the middle of a try-finally will still perform proper cleanup.
 */
class Shape {
    Shape(int i) {
        System.out.println("Shape constructor"); }
    void dispose() { System.out.println("Shape dispose"); }
}

class Circle extends Shape {
    Circle(int i) {
        super(i);
        System.out.println("Drawing Circle");
    }
    void dispose() {
        System.out.println("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    Triangle(int i) {
        super(i);
        System.out.println("Drawing Triangle");
    }
    void dispose() {
        System.out.println("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start, end;
    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Drawing Line: " + start + ", " + end);
    }
    void dispose() {
        System.out.println("Erasing Line: " + start + ", " + end);
        super.dispose();
    }
}

public class Ex16 extends Shape {
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];
    public Ex16(int i) {
        super(i + 1);
         for(int j = 0; j < lines.length; j++)
            lines[j] = new Line(j, j*j);
        c = new Circle(1);
        t = new Triangle(1);
        System.out.println("Combined constructor");
    }
    public void dispose() {
        System.out.println("CADSystem.dispose()");
        // The order of cleanup is the reverse
        // of the order of initialization:
        t.dispose();
        c.dispose();
        for(int i = lines.length - 1; i >= 0; i--)
            lines[i].dispose();
        super.dispose();
    }
    public static void main(String[] args) {
        Ex16 x = new Ex16(47);
        for(int i = 1; i <= 4; i++) {
            try {

                System.out.println("Point 1");
                if (i == 1) return;
                System.out.println("Point 2");
                if (i == 2) return;
                System.out.println("Point 3");
                if (i == 3) return;
                System.out.println("End");
                return;
            } finally {
                x.dispose();
            }
        }
    }
}
