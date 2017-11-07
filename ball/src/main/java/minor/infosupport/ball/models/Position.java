package minor.infosupport.ball.models;

public class Position {
    private int x = 0;
    private int y = 3;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
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
