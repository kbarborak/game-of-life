package coderetreat;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NeighbourResolver {

    public Set<Neighbour> resolveAll(Positionable position) {
        ArgumentValidator.throwIfNotPresent(position, "position");

        Set<Neighbour> neighbours = new HashSet<>();

        neighbours.add(new Neighbour(position.getX() - 1, position.getY() - 1));
        neighbours.add(new Neighbour(position.getX() - 1, position.getY()));
        neighbours.add(new Neighbour(position.getX() - 1, position.getY() + 1));
        neighbours.add(new Neighbour(position.getX(), position.getY() - 1));
        neighbours.add(new Neighbour(position.getX(), position.getY() + 1));
        neighbours.add(new Neighbour(position.getX() + 1, position.getY() - 1));
        neighbours.add(new Neighbour(position.getX() + 1, position.getY()));
        neighbours.add(new Neighbour(position.getX() + 1, position.getY() + 1));

        return neighbours;
    }

    public Set<Neighbour> resolvePopulated(Positionable position, Generation generation) {
        validateArguments(position, generation);

        return resolveAll(position).stream().filter(neighbour -> generation.containsLifeAt(neighbour)).collect(Collectors.toSet());
    }

    public Set<Neighbour> resolveUnpopulated(Positionable position, Generation generation) {
        validateArguments(position, generation);

        Set<Neighbour> neighbours = resolveAll(position);
        neighbours.removeAll(resolvePopulated(position, generation));
        return neighbours;
    }

    private void validateArguments(Positionable position, Generation generation) {
        ArgumentValidator.throwIfNotPresent(position, "position");
        ArgumentValidator.throwIfNotPresent(generation, "generation");
    }
}
