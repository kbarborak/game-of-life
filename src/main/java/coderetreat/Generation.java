package coderetreat;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generation {

    private Set<Life> population = new HashSet<>();
    private Integer age;

    public Generation() {
        age = 0;
    }

    /**
     * @param age number greater than 0
     */
    public Generation(Integer age) {
        ArgumentValidator.throwIfNotPresentWithTest(age, "age", "negative number",
                () -> age < 0);

        this.age = age;
    }

    public void addLife(Life life) {
        ArgumentValidator.throwIfNotPresent(life, "life");

        population.add(life);
    }

    public Boolean containsLife(Life life) {
        ArgumentValidator.throwIfNotPresent(life, "life");

        return population.contains(life);
    }

    public Boolean containsLifeAt(Positionable position) {
        ArgumentValidator.throwIfNotPresent(position, "position");

        return containsLife(new Life(position.getX(), position.getY()));
    }

    public Integer getAge() {
        return age;
    }

    public Integer countPopulation() {
        return population.size();
    }

    public Boolean hasPopulation() {
        return !population.isEmpty();
    }

    public Stream<Life> streamPopulation() {
        return population.stream();
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, population);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Generation)) {
            return false;
        }

        return Objects.equals(hashCode(), obj.hashCode());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + age + " [" + streamPopulation().map(life -> life.toString())
                .collect(Collectors.joining(", ")) + "]";
    }
}
