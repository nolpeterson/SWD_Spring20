/**
 * The game type Football.
 */
public class Football extends Game {
    /**
     * Instantiates a new Football game
     * @param homeTeam the home team
     * @param awayTeam the away team
     */
    Football(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        periodType = "Quarter";
        playPeriod = 1;
        periodLength = 15;
    }

    /**
     * Get scoring methods string [ ].
     * @return array of scoring methods
     */
    public static String[] getScoringMethods(){
        return new String[]{"Touchdown", "Extra Point", "Two Point Conversion", "Field Goal", "Safety"};
    }

    /**
     * Checks if game is over
     * @return true or false boolean
     */
    public static boolean isGameOver() {
        return playPeriod > 4;
    }
}
