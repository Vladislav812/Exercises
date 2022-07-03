package AutoClicker;

import java.awt.*;
import java.awt.event.InputEvent;

public class Clicker {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Robot r = new Robot();
            int button = InputEvent.BUTTON1_DOWN_MASK;
            //r.mouseMove(600, 600);
            r.mousePress(button);
            Thread.sleep(100);
            r.mouseRelease(button);
            Thread.sleep(100);
            r.mousePress(button);
            Thread.sleep(100);
            r.mouseRelease(button);
            Thread.sleep(2000);

        }
    }
}
