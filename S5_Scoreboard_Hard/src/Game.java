/**
 * Base class Game that all game types inherit from.
 */
public class Game {
    /**
     * The Home team.
     */
    protected Team homeTeam;
    /**
     * The Away team.
     */
    protected Team awayTeam;
    /**
     * The Period type.
     */
    protected String periodType;
    /**
     * The current playPeriod.
     */
    protected static int playPeriod;
    /**
     * The Period length.
     */
    protected int periodLength;

    /**
     * Instantiates a new Game and sets default values.
     */
    Game() {
        homeTeam = null;
        awayTeam = null;
        periodType = null;
        playPeriod = 0;
        periodLength = 0;
    }

    /**
     * Gets period type.
     * @return the period type
     */
    public String getPeriodType() {
        return periodType;
    }

    /**
     * Gets play period.
     * @return the play period
     */
    public int getPlayPeriod() {
        return playPeriod;
    }

    /**
     * Gets period length.
     * @return the period length
     */
    public int getPeriodLength() {
        return periodLength;
    }

    /**
     * End current period.
     */
    public void endPeriod(){
        playPeriod += 1;
    }

    /**
     * Get scoring methods for game type.
     * @param gameType the game type
     * @return array of scoring methods.
     */
    public static String[] getScoringMethods(String gameType) {
        String[] scoringMethods = {};
        switch (gameType) {
            case "basketball":
                scoringMethods = Basketball.getScoringMethods();
                break;
            case "football":
                scoringMethods = Football.getScoringMethods();
                break;
            case "hockey":
                scoringMethods = Hockey.getScoringMethods();
                break;
            case "soccer":
                scoringMethods = Soccer.getScoringMethods();
                break;
        }
        return scoringMethods;
    }

    /**
     * Gets the point values for each type of scoring method.
     * @param gameType the game type
     * @return array of point values for each score (ordered home, away team)
     */
    public static int[] getScoredPoints(String gameType) {
        int[] pointsScored = {};
        switch (gameType) {
            case "basketball":
                pointsScored = new int[]{3,2,1,3,2,1};
                break;
            case "football":
                pointsScored = new int[]{6,1,2,3,2,6,1,2,3,2};
                break;
            case "hockey":
            case "soccer":
                pointsScored = new int[]{1,1};
                break;
        }
        return pointsScored;
    }

    /**
     * Gets winning team.
     * @return the winning team
     */
    public String getWinningTeam() {
        if (homeTeam.getScore() > awayTeam.getScore()) {
            return (homeTeam.getName());
        }
        else if (homeTeam.getScore() == awayTeam.getScore()) {
            return ("Tie game");
        }
        else {
            return (awayTeam.getName());
        }
    }

    /**
     * Checks if the game is over
     * @param gameType the game type
     * @return true or false boolean
     */
    public static boolean isGameOver(String gameType) {
        boolean over = false;
        switch (gameType) {
            case "basketball":
                over =  Basketball.isGameOver();
                break;
            case "football":
                over = Football.isGameOver();
                break;
            case "hockey":
                over = Hockey.isGameOver();
                break;
            case "soccer":
                over = Soccer.isGameOver();
                break;
        }
        return over;
    }
}
