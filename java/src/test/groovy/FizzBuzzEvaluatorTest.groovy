import java.util.function.Function

import spock.lang.Specification


class FizzBuzzEvaluatorTest extends Specification {

    FizzBuzzEvaluator fizzBuzzEvaluator = new FizzBuzzEvaluator()

    def 'Passes the original input when functions return an empty string'() {
        given:
            int someNumber = 666
            Function<Integer, String> functionWhichReturnsEmptyString = {
                return ''
            }

            Function<Integer, String> secondFunctionWhichReturnsEmptyString = {
                return ''
            }

            def behaviors = [functionWhichReturnsEmptyString, secondFunctionWhichReturnsEmptyString]

        when:
            def result = fizzBuzzEvaluator.evaluateBehaviors(someNumber, behaviors)
        then:
            result == String.valueOf(someNumber)
    }

    def 'Applies the given functions and returns the result which consists of each function results'() {
        given:
            def mrruFunctionResult = 'Mrru'
            def fizzFunctionResult = 'Fizz'

            int someNumber = 666
            Function<Integer, String> functionWhichReturnsMrru = {
                return mrruFunctionResult
            }
            Function<Integer, String> functionWhichReturnsFizz = {
                return fizzFunctionResult
            }

            def behaviors = [functionWhichReturnsMrru, functionWhichReturnsFizz]
        when:
            def result = fizzBuzzEvaluator.evaluateBehaviors(someNumber, behaviors)
        then:
            result == mrruFunctionResult + fizzFunctionResult
    }

}
