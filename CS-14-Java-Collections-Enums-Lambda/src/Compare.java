import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Compare {
    public static void main(String[] args) {
        Comparator<Person>  compareByFirstNames = Comparator.comparing(Person:: getFirstName);
        Person joe = new Person("Joe", "Portman");
        Person allan = new Person("Allan", "Dale");
        List<Person> people = new ArrayList<>();
        people.add(joe);
        people.add(allan);
        people.sort(compareByFirstNames);

    }
}
