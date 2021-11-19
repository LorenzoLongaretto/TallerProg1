package testVentana;

import java.awt.*;
import java.awt.event.InputEvent;

public class Utils {
    public static final int delay = 700;

    public static void click(Robot robot){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(delay);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(delay);
    }
}
