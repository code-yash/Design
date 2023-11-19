package com.mycompany.cricketscorecard;

import models.Match;
import models.Team;

public class CricketScoreCard {

    public static void main(String[] args) {

        Team india = new Team("India");
        Team australia = new Team("Australia");
        Match match1 = new Match("Test Match", india, australia, 2, 5);
        match1.addPlayersToTeam(india, new String[]{"P1",
            "P2", "P3", "P4", "P5"}
        );
        match1.addPlayersToTeam(australia, new String[]{"P6",
            "P1", "P8", "P9", "P10"}
        );
        match1.startMatch(india);

    }
}
