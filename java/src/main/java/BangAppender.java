import java.util.Optional;

public class BangAppender {

    public int interval;

    final String BANG = "Bang";

    public BangAppender(int interval) {
        this.interval = interval;
    }

    public String appendBangIfNecessary(int studentIndex, String answer) {
        return Optional.ofNullable(answer).filter(ans -> studentIndex % interval == 0)
                .map(ans -> ans += BANG).orElse(answer);
    }


}
