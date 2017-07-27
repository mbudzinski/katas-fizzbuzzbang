import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class FizzBuzzEvaluator {

    public String evaluateBehaviors(int number, List<Function<Integer, String>> behaviors) {
        StringBuilder answerBuilder = new StringBuilder();
        behaviors.forEach(behavior -> answerBuilder.append(behavior.apply(number)));
        String result = answerBuilder.toString();
        return Optional.of(result).filter(res -> !res.isEmpty()).orElse(String.valueOf(number));
    }

}
