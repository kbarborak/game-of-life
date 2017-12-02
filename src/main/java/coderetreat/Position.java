package coderetreat;

import java.util.Objects;

public class Position implements Positionable {

    private Integer x;
    private Integer y;

    public Position(Integer x, Integer y) {
        ArgumentValidator.throwIfNotPresent(x, "x");
        ArgumentValidator.throwIfNotPresent(y, "y");

        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }

        return Objects.equals(hashCode(), obj.hashCode());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [" + x + ", " + y + "]";
    }
}
