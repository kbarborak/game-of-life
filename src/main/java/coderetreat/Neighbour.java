package coderetreat;

import java.util.Objects;

public class Neighbour implements Positionable {

    private Position position;

    public Neighbour(Integer x, Integer y) {
        position = new Position(x, y);
    }

    public Integer getX() {
        return position.getX();
    }

    public Integer getY() {
        return position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Neighbour)) {
            return false;
        }

        return Objects.equals(hashCode(), obj.hashCode());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [" + position.getX() + ", " + position.getY() + "]";
    }
}
