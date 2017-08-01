import spock.lang.Specification


class BangAppenderTest extends Specification {

    int interval = 10
    BangAppender bangAppender = new BangAppender(interval)

    def 'Appends Bang to the string if student index equals to the given interval'() {
        given:
            String originalString = 'SomeAnswer'
            int studentIndexWhichEqualsToInterval = interval
        when:
            def returnedString = bangAppender.appendBangIfNecessary(studentIndexWhichEqualsToInterval, originalString)
        then:
            returnedString == originalString + bangAppender.BANG
    }

    def 'Does not append bang to the string if student index does not equal to the given interval'() {
        given:
            String originalString = 'SomeAnswer'
            int studentIndexWhichDoesNotEqualToInterval = interval + 1
        when:
            def returnedString = bangAppender.appendBangIfNecessary(studentIndexWhichDoesNotEqualToInterval, originalString)
        then:
            !returnedString.contains(bangAppender.BANG)
    }

}
