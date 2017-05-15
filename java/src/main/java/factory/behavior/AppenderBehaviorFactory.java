package factory.behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
<<<<<<< 0e747d9f2d58483190497f3844906d9f789af910
=======
import java.util.function.UnaryOperator;
>>>>>>> Implemented a fizzBuzzBang method


public class AppenderBehaviorFactory implements AbstractConditionalBehaviorFactory {

    private static AppenderBehaviorFactory instance;

    private AppenderBehaviorFactory() {}

    public static AppenderBehaviorFactory getInstance() {
        if (instance == null) {
            instance = new AppenderBehaviorFactory();
        }
        return instance;

    }

    @Override
    public List<ConditionalBehavior> createBehaviorList() {

        List<ConditionalBehavior> behaviorList = new ArrayList<>();
        addBehaviorsTo(behaviorList);

        return behaviorList;
    }

    private void addBehaviorsTo(List<ConditionalBehavior> conditionalBehaviors) {
        addFizzBehavior(conditionalBehaviors);
        addPowBehavior(conditionalBehaviors);
        addBuzzBehavior(conditionalBehaviors);
        addMrruBehavior(conditionalBehaviors);
    }

    private void addFizzBehavior(List<ConditionalBehavior> conditionalBehaviors) {
        Function<Integer, String> appendFizzOperator = s -> "Fizz";

        ConditionalBehavior fizzBehavior = new ConditionalBehavior(number -> {
            boolean isNumberDivisibleByThree = number % 3 == 0;
            return isNumberDivisibleByThree;

        }, appendFizzOperator);

        conditionalBehaviors.add(fizzBehavior);
    }

    private void addPowBehavior(List<ConditionalBehavior> conditionalBehaviors) {

        Function<Integer, String> appendPowOperator = s -> "Pow";

        ConditionalBehavior powBehavior = new ConditionalBehavior(number -> {
            boolean isNumberDivisibleByThree = number % 3 == 0;
            boolean doesNumberContainNumberThree = String.valueOf(number).contains("3");
            return isNumberDivisibleByThree || doesNumberContainNumberThree;

        }, appendPowOperator);

        conditionalBehaviors.add(powBehavior);
    }

    private void addBuzzBehavior(List<ConditionalBehavior> behaviorList) {
        Function<Integer, String> appendBuzzOperator = s -> "Buzz";

        ConditionalBehavior buzzBehavior = new ConditionalBehavior(number -> {
            boolean isNumberDivisibleByFive = number % 5 == 0;
            return isNumberDivisibleByFive;
        }, appendBuzzOperator );

        behaviorList.add(buzzBehavior);
    }

    private void addMrruBehavior(List<ConditionalBehavior> behaviorList) {

        Function<Integer, String> appendMrruOperator = s -> "Mrru";

        ConditionalBehavior mrruBehavior = new ConditionalBehavior(number -> {
            boolean isNumberDivisibleByFive = number % 5 == 0;
            boolean doesNumberContainNumberFive = String.valueOf(number).contains("5");
            return isNumberDivisibleByFive || doesNumberContainNumberFive;
            }, appendMrruOperator );

        behaviorList.add(mrruBehavior);
    }

}
