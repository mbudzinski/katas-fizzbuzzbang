public class App {

    private static final int BANG_INTERVAL = 15;

    public static void main(String[] args) {
        FizzBuzzRunnerFactory factory = new FizzBuzzRunnerFactory();
        FizzBuzzRunner fizzBuzzRunner = factory.create(BANG_INTERVAL);
        fizzBuzzRunner.run(100);
    }
}
