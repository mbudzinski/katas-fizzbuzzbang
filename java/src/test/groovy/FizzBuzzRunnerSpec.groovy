import spock.lang.Specification


class FizzBuzzRunnerSpec extends Specification {

    AnswerSupplier answerSupplier = Mock(AnswerSupplier)
    def fizzBuzzRunner = new FizzBuzzRunner(answerSupplier)

    def 'fetches out answers until reaches the upper bound'() {
        given:
            int upperBound = 100
            String evaluatedAnswer = 'someAnswer'
            answerSupplier.getAnswerFor(_ as Integer) >> evaluatedAnswer
        when:
            fizzBuzzRunner.run(upperBound)
        then:
            upperBound * answerSupplier.getAnswerFor(_ as Integer)
    }

}
