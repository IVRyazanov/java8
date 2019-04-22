package Study.horstmann.chapter1.exersize12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Collection2<T> extends ArrayList<T> {

    public Collection2(List<T> strings) {
        super(strings);
    }

    void forEachIf(Consumer<T> action, Predicate<T> filter) {
        stream().filter(filter::test).forEach(action::accept);
    }

    public static void main(String[] args) {
        Collection2<String> collection2 = new Collection2<>(Arrays.asList("ONE", "TWO", "THREE"));
        collection2.forEachIf(System.out::println, (s)->s.contains("O"));
    }
}
