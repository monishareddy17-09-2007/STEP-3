class Scorecard {
    private boolean[] results;
    private final int totalQuestions;
    private int recordedAnswers;

    Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        results = new boolean[totalQuestions];
        recordedAnswers = 0;
    }

    void recordAnswer(boolean correct) {
        if (recordedAnswers < totalQuestions) {
            results[recordedAnswers] = correct;
            recordedAnswers++;
        } else {
            System.out.println("No more answers can be recorded");
        }
    }

    int getScore() {
        int score = 0;

        for (int i = 0; i < recordedAnswers; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class ScorecardDemo {
    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Quiz Score: " + sc.getScore());
    }
}