/**
 * The game type Basketball.
 */
public class Basketball extends Game {
    /**
     * Instantiates a new Basketball game
     * @param homeTeam the home team
     * @param awayTeam the away team
     */
    Basketball(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        periodType = "Half";
        playPeriod = 1;
        periodLength = 20;
    }

    /**
     * Get scoring methods string [ ].
     * @return array of scoring methods
     */
    public static String[] getScoringMethods(){
        return new String[]{"Three Pointer", "Two Pointer", "Free Throw"};
    }

    /**
     * Checks if game is over
     * @return true or false boolean
     */
    public static boolean isGameOver() {
        return playPeriod > 2;
    }
}
