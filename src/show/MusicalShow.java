package show;

import person.Director;
import person.Person;

public class MusicalShow extends Show {
    private final Person musicAuthor;
    private final String librettoText;

    public MusicalShow(
            String title,
            int duration,
            Director director,
            Person musicAuthor,
            String librettoText
    ) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibretto() {
        System.out.println(librettoText);
    }

    @Override
    public String toString() {
        return super.toString() + ", Композитор: " + musicAuthor;
    }
}
