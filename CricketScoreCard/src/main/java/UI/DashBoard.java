package UI;

import java.util.UUID;
import models.Player;
import models.Team;

public class DashBoard {

    String id;

    public DashBoard() {
        id = UUID.randomUUID().toString();
    }

    public void DisplayScorecard(Team currentTeam) {
        displayHeader(currentTeam);
        displayTeamScore(currentTeam);
        displayFinalScore(currentTeam);
    }

    public void displayHeader(Team currentTeam) {
        System.out.println("Team - " + currentTeam.getTeamName() + "ScoreCard");
        System.out.println("Player Name  |  SCORE   |  Numberof6  |  Numberof4 | NumberofBallsFaced");
    }

    public void displayTeamScore(Team currentTeam) {
        for (Player player : currentTeam.getTeamPlayer()) {
            System.out.println(player.getName() + "   " + player.getScore() + "   " + player.getNumberOfSix()
                    + "   " + player.getNumberOfFour() + "   " + player.getNumberOfBallsFaced());
        }
    }

    public void displayFinalScore(Team currentTeam) {
        System.out.println("Total - " + currentTeam.getTotalScore() + " / " + currentTeam.getTotalWicket());
    }

}
