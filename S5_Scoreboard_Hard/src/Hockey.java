/**
 * The game type Hockey.
 */
public class Hockey extends Game {
    /**
     * Instantiates a new Hockey game
     * @param homeTeam the home team
     * @param awayTeam the away team
     */
    Hockey(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        periodType = "Period";
        playPeriod = 1;
        periodLength = 20;
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
        return playPeriod > 3;
    }
}
