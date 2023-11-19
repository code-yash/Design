package models;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Team {

    String teamName;
    List<Player> players;
    Deque<Player> availablePlayers;
    int teamScore;
    int totalWicket;
    Player striker;
    Player runner;
    int extras;

    public Team(String teamName) {
        this.teamName = teamName;
        this.striker = null;
        this.runner = null;
        this.teamScore = 0;
        this.totalWicket = 0;
        this.players = new ArrayList<>();
        this.availablePlayers = new LinkedList<>();
        this.extras = 0;
    }

    public int getExtras() {
        return extras;
    }

    public void updateExtras() {
        this.extras++;
        this.teamScore++;
    }

    public List<Player> getTeamPlayer() {
        return players;
    }

    public int getTotalWicket() {
        return totalWicket;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTotalScore() {
        return teamScore;
    }

    public void addPlayerToTeam(Player player) {
        this.players.add(player);
        this.availablePlayers.addLast(player);
    }

    public void initializePlayer() {
        if (availablePlayers.size() >= 2) {
            this.striker = availablePlayers.poll();
            System.out.println(availablePlayers.size());
            this.runner = availablePlayers.poll();

        }

    }

    public void swapStrike() {
        Player temp = striker;
        striker = runner;
        runner = temp;
    }

    public void updateStrike(int run) {
        if (run % 2 != 0) {
            swapStrike();
        }
    }

    public void updateTeamScore(int run) {
        striker.updateScore(run);
        updateStrike(run);
        teamScore += run;

    }

    public boolean updateWicket() {
        totalWicket++;
        striker.updateScore(0);
        this.striker = availablePlayers.poll();
        if (striker == null) {
            return false;
        }
        return true;
    }
}
