import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class AnswerSupplier {

    private BangAppender bangAppender;

    private FizzBuzzEvaluator fizzBuzzEvaluator;

    private Function<Integer, String> fizzMatcher = (number) -> {
        if (number % 3 == 0) {
            return "Fizz";
        }
        return "";
    };

    private Function<Integer, String> buzzMatcher = (number) -> {
        if (number % 5 == 0) {
            return "Buzz";
        }
        return "";
    };

    private Function<Integer, String> powMatcher = (number) -> {
        if (number % 3 == 0 || number.toString().contains("3")) {
            return "Mrru";
        }
        return "";
    };

    private Function<Integer, String> mrruMatcher = (number) -> {
        if (number % 5 == 0 || number.toString().contains("5")) {
            return "Pow";
        }
        return "";
    };

    private List<Function<Integer, String>> behaviors = Arrays.asList(fizzMatcher, buzzMatcher, powMatcher, mrruMatcher);

    public AnswerSupplier(FizzBuzzEvaluator fizzBuzzEvaluator, BangAppender bangAppender) {
        this.fizzBuzzEvaluator = fizzBuzzEvaluator;
        this.bangAppender = bangAppender;
    }

    public String getAnswerFor(int number) {
        return bangAppender.appendBangIfNecessary(number, fizzBuzzEvaluator.evaluateBehaviors(number, behaviors));
    }


}
