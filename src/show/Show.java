package show;

import person.Actor;
import person.Director;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private final String title;
    private final int duration;
    private final Director director;
    private final List<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        director.increaseNumberOfShows();
    }

    public void printActors() {
        System.out.println("Список актеров:");
        for (int i = 0; i < listOfActors.size(); i++) {
            System.out.println((i + 1) + ". " + listOfActors.get(i));
        }
    }

    public void addActor(Actor newActor) {
        if (listOfActors.contains(newActor)) {
            System.out.println("Актер " + newActor + " уже участвует в спектакле " + title + ".");
        } else {
            listOfActors.add(newActor);
            System.out.println("Актер " + newActor + " добавлен в спектакль " + title + ".");
        }
    }

    public void changeActor(Actor newActor, Actor oldActor) {
        if (listOfActors.contains(newActor)) {
            System.out.println("Актер " + newActor + " уже участвует в спектакле " + title + ".");
            return;
        }

        int index = listOfActors.indexOf(oldActor);
        if (index != -1) {
            listOfActors.set(index, newActor);
            System.out.println("Актер " + oldActor + " заменен на " + newActor + " в спектакле " + title + ".");
        } else {
            System.out.println("Актер " + oldActor + " не участвует в спектакле " + title + ".");
        }
    }

    @Override
    public String toString() {
        return "Спектакль: " + title +
                ", Продолжительность: " + duration + "мин." +
                ", Режиссер: " + director;
    }
}
