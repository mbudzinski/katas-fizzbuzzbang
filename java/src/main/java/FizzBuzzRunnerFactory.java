
public class FizzBuzzRunnerFactory {

    public FizzBuzzRunner create(int interval) {
        FizzBuzzEvaluator fizzBuzzEvaluator = new FizzBuzzEvaluator();
        BangAppender bangAppender = new BangAppender(interval);
        AnswerSupplier answerSupplier = new AnswerSupplier(fizzBuzzEvaluator, bangAppender);
        FizzBuzzRunner fizzBuzzRunner = new FizzBuzzRunner(answerSupplier);
        return fizzBuzzRunner;
    }

}
