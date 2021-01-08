/**
 * Team object that holds a team name, and team score.
 */
public class Team {
    private String name;
    private int score;

    /**
     * Instantiates a new Team.
     */
    Team(){
        name = null;
        score = 0;
    }

    /**
     * Sets team name.
     * @param name the team name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets team name.
     * @return the team name
     */
    public String getName() {
        return name;
    }

    /**
     * Add team score.
     * @param points the points to be added
     */
    public void addScore(int points) {
        score += points;
    }

    /**
     * Sets team score.
     * @param points the points to be added
     */
    public void setScore(int points) {
        this.score = points;
    }

    /**
     * Gets team score.
     * @return the team score
     */
    public int getScore() {
        return score;
    }
}
