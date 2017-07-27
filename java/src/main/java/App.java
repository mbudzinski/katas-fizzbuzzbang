public class App {


    public static void main(String[] args) {
        FizzBuzzEvaluator fizzBuzzEvaluator = new FizzBuzzEvaluator();
        BangAppender bangAppender = new BangAppender(15);
        AnswerSupplier answerSupplier = new AnswerSupplier(fizzBuzzEvaluator, bangAppender);
        FizzBuzzRunner fizzBuzzRunner = new FizzBuzzRunner(answerSupplier);

        fizzBuzzRunner.run(100);
    }

}
