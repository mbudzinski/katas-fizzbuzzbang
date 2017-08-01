import java.util.stream.IntStream;

public class FizzBuzzRunner {

    private AnswerSupplier answerSupplier;

    public FizzBuzzRunner(AnswerSupplier answerSupplier) {
        this.answerSupplier = answerSupplier;
    }

    public void run(int upperBound) {
        IntStream.range(1, upperBound + 1).mapToObj(index -> answerSupplier.getAnswerFor(index)).forEach(System.out::println);
    }
}
