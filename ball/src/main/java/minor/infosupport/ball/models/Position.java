package minor.infosupport.ball.models;

public class Position {
    private int x = 100;
    private int y = 100;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this.x = 100;
        this.y = 100;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
