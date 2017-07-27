import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FizzBuzzRunner {

    private AnswerSupplier answerSupplier;



    public FizzBuzzRunner(AnswerSupplier answerSupplier) {
        this.answerSupplier = answerSupplier;
    }

    public void run(int upperBound) {
        for (int studentIndex = 1; studentIndex <= upperBound; studentIndex++) {
            String answer = answerSupplier.getAnswerFor(studentIndex);
            printAnswer(answer);
        }
    }

    protected void printAnswer(String answer) {
        System.out.println(answer);
    }



}
