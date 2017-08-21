import spock.lang.Specification


class AnswerSupplierSpec extends Specification {

    FizzBuzzEvaluator fizzBuzzEvaluator = Mock(FizzBuzzEvaluator)
    BangAppender bangAppender = Mock(BangAppender)
    AnswerSupplier answerSupplier = new AnswerSupplier(fizzBuzzEvaluator, bangAppender)

    def 'Invokes the bang appender when reaching for answer' () {
        given:
            def someNumber = 666
            def someAnswer = 'someAnswer'
            fizzBuzzEvaluator.evaluateBehaviors(someNumber, _ as List) >> someAnswer
        when:
            answerSupplier.getAnswerFor(someNumber)
        then:
            1 * bangAppender.appendBangIfNecessary(someNumber, someAnswer)
    }

    def 'Invokes the fizzBuzzEvaluator when reaching for answer' () {
        given:
            def someNumber = 666
        when:
            answerSupplier.getAnswerFor(someNumber)
        then:
            1 * fizzBuzzEvaluator.evaluateBehaviors(someNumber, _ as List)

    }


}
