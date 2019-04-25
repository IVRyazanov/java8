package Study.horstmann.chapter2.exersize1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ForStream {
    public static void main(String[] args) throws IOException, InterruptedException {
        timing(ForStream::withoutStreamMethod);
        timing(ForStream::simpleStream);
        timing(ForStream::parralellStream);
    }

    public interface MyEventConsumer {
        public void consume();
    }

    public static void timing(MyEventConsumer function) throws IOException {
        Long stTimeInSec = Instant.now().toEpochMilli();
        function.consume();
        Long endTimeInSec = Instant.now().toEpochMilli();
        System.out.println("execution of " + function + " time count = " + (endTimeInSec - stTimeInSec));
    }

    public static void withoutStreamMethod() {
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
                i++;
            }
        }
        System.out.println("wordCount = " + i);
    }


    public static void simpleStream() {
        String string = null;
        try {
            string = new String(Files.readAllBytes(Paths.get("C:\\Users\\Иван\\IdeaProjects\\java8\\src\\main\\java\\Study\\horstmann\\chapter2\\exersize1\\alice.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> words = Arrays.asList(string.split("[\\P{L}+]"));
        Stream<String> stream = words.stream();
        stream.filter(s -> s.length() > 12).count();
    }

    public static void parralellStream() {
        String string = null;
        try {
            string = new String(Files.readAllBytes(Paths.get("C:\\Users\\Иван\\IdeaProjects\\java8\\src\\main\\java\\Study\\horstmann\\chapter2\\exersize1\\alice.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> words = Arrays.asList(string.split("[\\P{L}+]"));
        Stream<String> stream = words.parallelStream();
        stream.filter(s -> s.length() > 12).count();
    }
}
