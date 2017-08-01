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
            def MRRU_FUNCTION_RESULT = 'Mrru'
            def FIZZ_FUNCTION_RESULT = 'Fizz'

            int someNumber = 666
            Function<Integer, String> functionWhichReturnsMrru = {
                return MRRU_FUNCTION_RESULT
            }
            Function<Integer, String> functionWhichReturnsFizz = {
                return FIZZ_FUNCTION_RESULT
            }

            def behaviors = [functionWhichReturnsMrru, functionWhichReturnsFizz]
        when:
            def result = fizzBuzzEvaluator.evaluateBehaviors(someNumber, behaviors)
        then:
            result == MRRU_FUNCTION_RESULT + FIZZ_FUNCTION_RESULT
    }

    def 'On integers divisible by 3 returns Fizz if supplied with fizz matcher' () {
        given:

            def numberDivisibleBy3 = 300
            def FIZZ = 'Fizz'

            Function<Integer, String> fizzMatcher = {
                if (numberDivisibleBy3 % 3 == 0) {
                    return FIZZ
                }
            }

            def behaviors = [fizzMatcher]

        when:
            def result = fizzBuzzEvaluator.evaluateBehaviors(numberDivisibleBy3, behaviors)
        then:
            result == FIZZ
    }

    def 'On integers divisible by 5 returns Buzz if supplied with buzz matcher' () {
        given:

            def numberDivisibleBy5 = 500
            def BUZZ = 'Buzz'

            Function<Integer, String> buzzMatcher = {
                if (numberDivisibleBy5 % 5 == 0) {
                    return BUZZ
                }
            }

            def behaviors = [buzzMatcher]

        when:
            def result = fizzBuzzEvaluator.evaluateBehaviors(numberDivisibleBy5, behaviors)
        then:
            result == BUZZ
    }

    def 'On integers divisible by 5 or containing 5 returns Mrru if supplied with Mrru Matcher' () {
        given:

            def Mrru = 'Mrru'

            Function<Integer, String> mrruMatcher = {
                if (numberWith5OrDivisibleBy5 % 5 == 0 || String.valueOf(numberWith5OrDivisibleBy5).contains('5')) {
                    return Mrru
                }
            }

            def behaviors = [mrruMatcher]

        when:
            def result = fizzBuzzEvaluator.evaluateBehaviors(numberWith5OrDivisibleBy5, behaviors)
        then:
            result == Mrru
        where:
            numberWith5OrDivisibleBy5 << [555, 53]
    }

    def 'On integers divisible by 3 or containing 3 returns Pow if supplied with Pow Matcher' () {
        given:
            def POW = 'Pow'

            Function<Integer, String> powMatcher = {
                if (numberWith3OrDivisibleBy3 % 3 == 0 || String.valueOf(numberWith3OrDivisibleBy3).contains('3')) {
                    return POW
                }
            }

            def behaviors = [powMatcher]

        when:
            def result = fizzBuzzEvaluator.evaluateBehaviors(numberWith3OrDivisibleBy3, behaviors)
        then:
            result == POW
        where:
            numberWith3OrDivisibleBy3 << [333, 13]
    }

}
