package person;

import java.util.Objects;

public class Actor extends Person {
    private final int height;

    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + " (рост " + height + "см.)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Actor actor)) {
            return false;
        }
        return Objects.equals(this.getName(), actor.getName())
                && Objects.equals(this.getSurname(), actor.getSurname())
                && Objects.equals(this.height, actor.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getSurname(), this.height);
    }
}
