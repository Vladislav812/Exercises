package Stepik.JavaBase.RobotMove;

public class MoveRobot {
    public static void main(String[] args) {
        Robot robot = new Robot(Direction.UP, 0, 0);
        int toX = 3, toY = 0;
        int dX = robot.getX() - toX;
        int dY = robot.getY() - toY;

        if (dX > 0) {
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnLeft();
            }
        } else {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnLeft();
            }
        }
        for (int i = 0; i < Math.abs(dX); i++) {
            robot.stepForward();
        }

        if (dY > 0) {
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnLeft();
            }
        } else {
            while (robot.getDirection() != Direction.UP) {
                robot.turnLeft();
            }
        }
        for (int i = 0; i < Math.abs(dY); i++) {
            robot.stepForward();
        }


        System.out.println(robot.getX() + " " + robot.getY());
    }
}
