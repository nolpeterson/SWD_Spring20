import java.util.Scanner;

/**
 * Main class that runs the scoreboard application.
 */
public class RunScoreboard {
    /**
     * Main method that runs the user interface.
     * @param args the args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //Teams
        Team homeTeam = new Team();
        Team awayTeam = new Team();

        //Interface to pick game type
        System.out.println("Select game type:\n1. Basketball\n2. Football\n3. Hockey\n4. Soccer");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();

        //Make sure choice is valid
        while (choice < 1 || choice > 4) {
            System.out.print("Invalid choice, please enter choice: ");
            choice = input.nextInt();
        }

        //Output formatting
        System.out.println();

        //Get names for home and away teams
        System.out.print("Enter home team: ");
        homeTeam.setName(input.next());
        System.out.print("Enter away team: ");
        awayTeam.setName(input.next());

        //Variables for game.
        Game myGame = null;
        String gameType = null;
        String[] scoringMethods;
        int[] scoredPoints;

        //Specify what type of game is being played by user choice.
        switch(choice) {
            case 1:
                myGame = new Basketball(homeTeam, awayTeam);
                gameType = "basketball";
                break;
            case 2:
                myGame = new Football(homeTeam, awayTeam);
                gameType = "football";
                break;
            case 3:
                myGame = new Hockey(homeTeam, awayTeam);
                gameType = "hockey";
                break;
            case 4:
                myGame = new Soccer(homeTeam, awayTeam);
                gameType = "soccer";
                break;
        }

        //Game loop that runs until the game is over.
        while (!Game.isGameOver(gameType)){
            scoringMethods = Game.getScoringMethods(gameType);
            scoredPoints = Game.getScoredPoints(gameType);
            System.out.print("\n" + myGame.homeTeam.getName() + " - " + myGame.homeTeam.getScore()
                    + ", " + myGame.awayTeam.getName() + " - " + myGame.awayTeam.getScore()
                    + "\nCurrent " + myGame.getPeriodType() + ": " + myGame.getPlayPeriod());
            System.out.println("\n-Menu-");
            for (int j = 0; j < scoringMethods.length; j++) {
                System.out.print(j +  ". " + myGame.homeTeam.getName() + " " + scoringMethods[j] + "\n");
            }
            for (int j = 0; j < scoringMethods.length; j++) {
                System.out.print((scoringMethods.length+j) +  ". " + myGame.awayTeam.getName() + " " + scoringMethods[j] + "\n");
            }
            System.out.print((scoringMethods.length*2) + ". End " + myGame.getPeriodType() + "\nEnter choice: ");
            choice = input.nextInt();
            if (choice == (scoringMethods.length*2)) {
                myGame.endPeriod();
            }
            else if (choice < (scoringMethods.length)) {
                homeTeam.addScore(scoredPoints[choice]);
            }
            else if (choice >= (scoringMethods.length) && choice < (scoringMethods.length*2)) {
                awayTeam.addScore(scoredPoints[choice]);
            }
        }

        //Final score and winner (or tie) output
        System.out.print("\n-Game Over-\n" + myGame.homeTeam.getName() + " - " + myGame.homeTeam.getScore()
                + ", " + myGame.awayTeam.getName() + " - " + myGame.awayTeam.getScore()
                + "\nWinner: " + myGame.getWinningTeam());
    }
}
