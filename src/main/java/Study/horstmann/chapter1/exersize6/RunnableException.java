package Study.horstmann.chapter1.exersize6;

import java.util.concurrent.Callable;

public class RunnableException {
    public static void main(String[] args) {
        new Thread(uncheck(()-> {
            Thread.sleep(1000);
            System.out.println("exc");
            return null;
        } )).start();

    }

    private static Runnable uncheck(Callable<Void> runnable) {
        return () -> {
            try {
                runnable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
