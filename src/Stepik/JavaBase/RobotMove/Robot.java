package Stepik.JavaBase.RobotMove;

public class Robot {

    private int X;
    private int Y;
    private Direction dr;

    public Direction getDirection() {
        return dr;
        // текущее направление взгляда
    }

    public int getX() {
        return X;
        // текущая координата X
    }

    public int getY() {
        return Y;
        // текущая координата Y
    }

    public Robot() {

    }

    Robot(Direction dr, int X, int Y) {
        this.dr = dr;
        this.X = X;
        this.Y = Y;
    }

    public void turnLeft() {
        switch (dr) {
            case UP -> dr = Direction.LEFT;
            case DOWN -> dr = Direction.RIGHT;
            case LEFT -> dr = Direction.DOWN;
            case RIGHT -> dr = Direction.UP;
        }

        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        switch (dr) {
            case UP -> dr = Direction.RIGHT;
            case DOWN -> dr = Direction.LEFT;
            case RIGHT -> dr = Direction.DOWN;
            case LEFT -> dr = Direction.UP;
        }

        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        switch (dr) {
            case UP -> Y++;
            case DOWN -> Y--;
            case LEFT -> X--;
            case RIGHT -> X++;
        }
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}
