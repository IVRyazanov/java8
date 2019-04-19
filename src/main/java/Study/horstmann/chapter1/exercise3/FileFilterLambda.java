package Study.horstmann.chapter1.exercise3;

import java.io.File;

public class FileFilterLambda {
    public static void main(String[] args) {
        File file = new File(".");
        File[] files = file.listFiles((dir, name) -> name.endsWith(".gitignore"));
        if (files != null) {
            for (File file1 : files) {
                System.out.println(file1);
            }
        }
    }
}
