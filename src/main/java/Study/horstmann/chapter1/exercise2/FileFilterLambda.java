package Study.horstmann.chapter1.exercise2;

import java.io.File;

public class FileFilterLambda {
    public static void main(String[] args) {
        File file = new File("../");

        File[] directories = file.listFiles(File::isDirectory);

        if (directories != null) {
            for (File dirs : directories) {
                System.out.println(dirs);
            }
        }
    }
}
