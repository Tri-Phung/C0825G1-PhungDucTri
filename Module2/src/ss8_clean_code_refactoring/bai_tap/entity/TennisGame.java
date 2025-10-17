package ss8_clean_code_refactoring.bai_tap.entity;

public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;
    public static final int WINNING_SCORE = 4;
    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return getTieScore(player1Score);
        } else if (player1Score >= WINNING_SCORE || player2Score >= WINNING_SCORE) {
            return getAdvantageScore(player1Score, player2Score);
        } else {
            return getNormalScore(player1Score, player2Score);
        }
    }

    private static String getNormalScore(int player1Score, int player2Score) {
        return SCORE_NAMES[player1Score] + "-" + SCORE_NAMES[player2Score];
    }

    private static String getAdvantageScore(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private static String getTieScore(int player1Score) {
        return switch (player1Score) {
            case LOVE -> "Love-All";
            case FIFTEEN -> "Fifteen-All";
            case THIRTY -> "Thirty-All";
            case FORTY -> "Forty-All";
            default -> "Deuce";
        };
    }
}