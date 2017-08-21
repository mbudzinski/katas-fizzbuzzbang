import spock.lang.Specification

class FizzBuzzRunnerFactorySpec extends Specification {


    def 'creates new instances of FizzBuzzRunner'() {
        given:
            def irrelevantBangInterval = 10

        when:
            def runner = fizzBuzzRunnerFactory.create(irrelevantBangInterval)
            def secondRunner = fizzBuzzRunnerFactory.create(irrelevantBangInterval)
        then:
            runner instanceof FizzBuzzRunner
            secondRunner instanceof FizzBuzzRunner
            secondRunner != runner
    }

    FizzBuzzRunnerFactory fizzBuzzRunnerFactory = new FizzBuzzRunnerFactory()

}
