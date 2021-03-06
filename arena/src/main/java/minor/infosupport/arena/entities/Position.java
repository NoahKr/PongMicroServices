package minor.infosupport.arena.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Position {

    private long x;
    private long y;

    public long getX() {
        return x;
    }

    public Position setX(long x) {
        this.x = x;

        return this;
    }

    public long getY() {
        return y;
    }

    public Position setY(long y) {
        this.y = y;

        return this;
    }

}
