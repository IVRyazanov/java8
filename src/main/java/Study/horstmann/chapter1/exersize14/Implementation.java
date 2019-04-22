package Study.horstmann.chapter1.exersize14;

public class Implementation implements I,J{
    @Override
    public void f() {
        System.out.println("implementation");
    }

    public static void main(String[] args) {
        new ImplementationSub().f();
    }
}
