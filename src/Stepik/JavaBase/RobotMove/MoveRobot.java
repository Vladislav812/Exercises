package Stepik.JavaBase.RobotMove;

public class MoveRobot {
    public static void main(String[] args) {
        Robot robot = new Robot(Direction.UP, 0, 0);
        int toX = 3, toY = 0;
        int dX = robot.getX() - toX;
        int dY = robot.getY() - toY;

        robotUp(robot);
        if (dX > 0) {
            robot.turnLeft();
        } else {
            robot.turnRight();
        }
        for (int i = 0; i < Math.abs(dX); i++) {
            robot.stepForward();
        }

        robotUp(robot);
        if (dY > 0) {
            robot.turnLeft();
            robot.turnLeft();
        }
        for (int i = 0; i < Math.abs(dY); i++) {
            robot.stepForward();
        }

        System.out.println(robot.getX() + " " + robot.getY());
    }

    static void robotUp(Robot robot) {
        while (robot.getDirection() != Direction.UP) {
            robot.turnLeft();
        }
    }
}
