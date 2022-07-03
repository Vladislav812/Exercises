import java.awt.*;
import java.util.ArrayList;

public class ReferenceTest {
    public static void main(String[] args) {
        Point pt1, pt2;
        pt1 = new Point(100, 100);
        ArrayList<Integer> va = new ArrayList<Integer>();


        pt2 = pt1;
        pt2 = new Point(100, 100);
        pt1.x = 200;
        pt1.y = 200;
        System.out.println("Point1: " + pt1.x + ", " + pt1.y);
        System.out.println("Point2: " + pt2.x + ", " + pt2.y);
    }
}
