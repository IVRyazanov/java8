package Study.horstmann.chapter2.exersize1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ForStream {
    public static void main(String[] args) throws IOException, InterruptedException {
        timing(()-> withoutStreamMethod());
        withoutStreamMethod();
        simpleStream();
        parralellStream();
    }

    public static <T> Consumer timing(Consumer<T> function) throws IOException{
        return o -> {
            Long stTimeInSec = Instant.now().toEpochMilli();
            function.accept(null);
            Long endTimeInSec = Instant.now().toEpochMilli();
            System.out.println("execution of " + function + " time count = " +  (endTimeInSec - stTimeInSec));
        };
    }

    public static void withoutStreamMethod() {
        Long stTimeInSec = Instant.now().toEpochMilli();
        String string = null;
        try {
            string = new String(Files.readAllBytes(Paths.get("C:\\Users\\Иван\\IdeaProjects\\java8\\src\\main\\java\\Study\\horstmann\\chapter2\\exersize1\\alice.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> words = Arrays.asList(string.split("[\\P{L}+]"));
        int i = 0;
        for (String word : words) {
            if (word.length() > 12) {
                System.out.println(word);
                i++;
            }
        }
        System.out.println("wordCount = " + i);
        Long endTimeInSec = Instant.now().toEpochMilli();
        System.out.println("withoutStreamMethod time count = " +  (endTimeInSec - stTimeInSec));
    }


    public static void simpleStream() throws IOException {
        Long stTimeInSec = Instant.now().toEpochMilli();
        String string = new String(Files.readAllBytes(Paths.get("C:\\Users\\Иван\\IdeaProjects\\java8\\src\\main\\java\\Study\\horstmann\\chapter2\\exersize1\\alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(string.split("[\\P{L}+]"));
        Stream<String> stream = words.stream();
        stream.filter(s->s.length()> 12).count();
        Long endTimeInSec = Instant.now().toEpochMilli();
        System.out.println("simpleStream time count = " +  (endTimeInSec - stTimeInSec));
    }

    public static void parralellStream() throws IOException {
        Long stTimeInSec = Instant.now().toEpochMilli();
        String string = new String(Files.readAllBytes(Paths.get("C:\\Users\\Иван\\IdeaProjects\\java8\\src\\main\\java\\Study\\horstmann\\chapter2\\exersize1\\alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(string.split("[\\P{L}+]"));
        Stream<String> stream = words.parallelStream();
        stream.filter(s->s.length()> 12).count();
        Long endTimeInSec = Instant.now().toEpochMilli();
        System.out.println("parralellStream time count = " +  (endTimeInSec - stTimeInSec));
    }
}
