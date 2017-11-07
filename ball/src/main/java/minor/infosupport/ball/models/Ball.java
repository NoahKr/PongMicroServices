package minor.infosupport.ball.models;

import java.io.Serializable;

public class Ball implements Serializable {

    private int width = 5;
    private int height = 5;

    private Position position;

    private int speed = 5;

    private int directionX = 1;
    private int directionY = 1;

    public Ball(int width, int height, int positionX, int positionY) {
        this.width = width;
        this.height = height;
        this.position = new Position(positionX, positionY);
    }

    public Ball(int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Position();
    }

    public Ball() {
        this.position = new Position();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
