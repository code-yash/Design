package models;

import UI.DashBoard;
import static java.lang.Math.abs;
import java.util.Scanner;

public class Match {

    String matchName;
    int numberofPlayersInTeam;
    int numberofOvers;
    Team team1;
    Team team2;
    Team currentBattingTeam;
    Team previousBattingTeam;
    DashBoard dashboard;

    public Match(String matchName, Team team1, Team team2, int numberofOvers, int numberofPlayersInTeam) {
        this.matchName = matchName;
        this.numberofOvers = numberofOvers;
        this.numberofPlayersInTeam = numberofPlayersInTeam;
        this.team1 = team1;
        this.team2 = team2;
        dashboard = new DashBoard();
        currentBattingTeam = null;
        previousBattingTeam = null;
    }

    public void addPlayersToTeam(Team team, String[] listOfPlayers) {
        //check if number of players is less or greater than input then throw error
        if (listOfPlayers.length != numberofPlayersInTeam) {
            System.out.println("Invalid number of Players ");
            return;
        }
        for (String name : listOfPlayers) {
            team.addPlayerToTeam(new Player(name));
        }
    }

    public void startMatch(Team currentTeam) {
        currentBattingTeam = currentTeam;
        startBatting();
        switchTeams();
        startBatting();
        displayResult();
    }

    public void startBatting() {
        currentBattingTeam.initializePlayer();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numberofOvers; i++) {
            System.out.println("Team " + currentBattingTeam.getTeamName() + " Playing");
            for (int j = 0; j < 6; j++) {
                System.out.println("Enter Run of Over " + (i + 1) + " Ball " + (j + 1));
                String run = sc.nextLine();
                if (run.equals("WD")) {
                    j--;
                }
                if (!updateScore(run) || (previousBattingTeam != null
                        && this.currentBattingTeam.getTotalScore() >= this.previousBattingTeam.getTotalScore())) {
                    dashboard.DisplayScorecard(currentBattingTeam);
                    return;
                }
            }
            currentBattingTeam.swapStrike();
            dashboard.DisplayScorecard(currentBattingTeam);
        }
    }

    public boolean updateScore(String run) {
        if (run.equals("W")) {
            return currentBattingTeam.updateWicket();
        } else if (run.equals("WD")) {
            currentBattingTeam.updateExtras();
        } else {
            currentBattingTeam.updateTeamScore(Integer.parseInt(run));
        }
        return true;
    }

    public void switchTeams() {
        if (currentBattingTeam == team1) {
            previousBattingTeam = team2;
        } else {
            previousBattingTeam = team1;
        }
        Team temp = currentBattingTeam;
        currentBattingTeam = previousBattingTeam;
        previousBattingTeam = temp;
    }

    public void displayResult() {
        Team winner = null;
        if (currentBattingTeam.getTotalScore() > previousBattingTeam.getTotalScore()) {
            winner = currentBattingTeam;
        } else {
            winner = previousBattingTeam;
        }
        int scorediff = abs(currentBattingTeam.getTotalScore() - previousBattingTeam.getTotalScore());
        System.out.println("Winner of " + matchName + " is team - " + winner.getTeamName() + " by " + scorediff + " runs");
    }

}
