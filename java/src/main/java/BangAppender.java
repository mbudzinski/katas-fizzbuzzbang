
public class BangAppender {

    public int interval;

    String bang = "Bang";

    public BangAppender(int interval) {
        this.interval = interval;
    }

    public String appendBangIfNecessary(int studentIndex, String answer) {
        if (studentIndex % interval == 0) {
            answer += bang;
        }
        return answer;
    }


}
