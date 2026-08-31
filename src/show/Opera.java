package show;

import person.Director;
import person.Person;

public class Opera extends MusicalShow {
    private final int choirSize;

    public Opera(
            String title,
            int duration,
            Director director,
            Person musicAuthor,
            String librettoText,
            int choirSize
    ) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    @Override
    public String toString() {
        return super.toString() + ", Количество человек в хоре - " + choirSize;
    }
}
