import person.Actor;
import person.Director;
import person.Gender;
import person.Person;
import show.Ballet;
import show.Opera;
import show.Show;

public class Theatre {

    public static void main(String[] args) {
        Actor actor1 = new Actor("Иван", "Петров", Gender.MALE, 180);
        Actor actor2 = new Actor("Мария",  "Смирнова", Gender.FEMALE, 167);
        Actor actor3 = new Actor("Алексей", "Иванов", Gender.MALE, 175);

        Director director1 = new Director("Сергей", "Соловьёв", Gender.MALE, 25);
        Director director2 = new Director("Елена", "Козлова", Gender.FEMALE, 18);

        Person composer = new Person("Пётр", "Чайковский", Gender.MALE);
        Person choreographer = new Person("Рудольф", "Нуриев", Gender.MALE);

        System.out.println("Информация о режиссерах театра:");
        printInformationAbout(director1);
        printInformationAbout(director2);

        Show show = new Show("Тени прошлого", 135, director1);
        show.addActor(actor1);
        show.addActor(actor2);

        Opera opera = new Opera(
                "Голоса Вечного Города",
                165,
                director2,
                composer,
                """
                        Венеция, 1720 год. Певец Марко влюблён в Джульетту, дочь дожа.
                        Отец против и хочет выдать её за графа. Влюблённые решают бежать, но их замечают.
                        Дуэль Марко и графа. Дож соглашается на брак, если Марко докажет своё благородство.
                        Свадьба в соборе Святого Марка.
                        """,
                10
        );
        opera.addActor(actor2);
        opera.addActor(actor3);

        Ballet ballet = new Ballet(
                "Зачарованный Сад",
                150,
                director1,
                composer,
                """
                        Заколдованный сад спит тысячу лет. Принцесса Элиза танцует, оживляя статуи на миг.
                        Дух Тень похищает Элизу. Садовник Леон узнаёт, что только танец чистой любви разрушит чары.
                        Леон проникает в замок Тьмы, дуэль-танец с Тенью. Свет Элизы и Леона разрушает замок.
                        Сад пробуждается, наступает рассвет. Победа света и любви.
                        """,
                choreographer
        );
        ballet.addActor(actor2);

        printInformationAbout(show);
        printInformationAbout(opera);
        printInformationAbout(ballet);

        Actor actor4 = new Actor("Евгений", "Иванов", Gender.MALE, 170);
        Actor actor5 = new Actor("Петр", "Иванов", Gender.MALE, 180);

        opera.addActor(actor4);
        printInformationAbout(opera);
        // Сейчас в спектакле есть несколько человек с одинаковой фамилией.
        // Если бы мы хотели поменять актера, зная только фамилию, можно было бы поменять не того.
        // Поэтому вместо фамилии используем экземпляр Actor.
        opera.changeActor(actor5, actor4);

        // Попытка заменить несуществующего актера.
        ballet.changeActor(actor1, actor3);

        System.out.println("Полная информация о спектаклях.");
        printInformationAbout(show);

        printInformationAbout(opera);
        opera.printLibretto();

        printInformationAbout(ballet);
        ballet.printLibretto();

        System.out.println("Информация о режиссерах театра:");
        printInformationAbout(director1);
        printInformationAbout(director2);
    }

    private static void printInformationAbout(Show show) {
        System.out.println(show);
        show.printActors();
    }

    private static void printInformationAbout(Director director) {
        System.out.println("Режиссер: " + director);
        System.out.println("Количество поставленных спектаклей: " + director.getNumberOfShows());
    }
}
