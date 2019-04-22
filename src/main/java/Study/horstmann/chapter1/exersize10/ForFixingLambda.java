package Study.horstmann.chapter1.exersize10;

import java.util.ArrayList;
import java.util.List;

public class ForFixingLambda {
    public static void main(String[] args) {
        String[] strings = new String[]{"one", "two", "three"};
        List<Runnable> runnableList = new ArrayList<>();
        for (String string : strings) {
            runnableList.add(()-> System.out.println(string));
        }

        strings[0] = "ONE_OVERIDE";
        for (Runnable runnable : runnableList) {
            new Thread(runnable).start();
        }


    }
}
