/**
 * The game type Soccer.
 */
public class Soccer extends Game {
    /**
     * Instantiates a new Soccer game
     * @param homeTeam the home team
     * @param awayTeam the away team
     */
    Soccer(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        periodType = "Half";
        playPeriod = 1;
        periodLength = 45;
    }

    /**
     * Get scoring methods string [ ].
     * @return array of scoring methods
     */
    public static String[] getScoringMethods(){
        return new String[]{"Goal"};
    }

    /**
     * Checks if game is over
     * @return true or false boolean
     */
    public static boolean isGameOver() {
        return playPeriod > 2;
    }
}
