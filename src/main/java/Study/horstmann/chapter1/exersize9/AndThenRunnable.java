package Study.horstmann.chapter1.exersize9;

public class AndThenRunnable {
    public static void main(String[] args) {
        new Thread(andThen(() -> {
            System.out.println("Thread 1");
        }, () -> {
            System.out.println("Thread 2");
        })).start();
    }

    static Runnable andThen(Runnable runnable1, Runnable runnable2) {
        return () -> {
            runnable1.run();
            runnable2.run();
        };
    }
}
