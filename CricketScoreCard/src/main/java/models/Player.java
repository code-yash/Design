package models;

public class Player {

    String name;
    int score;
    int numberOfBallsFaced;
    int numberOfWicketsTaken;
    int numberOfFour;
    int numberOfSix;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.numberOfBallsFaced = 0;
        this.numberOfWicketsTaken = 0;
        this.numberOfFour = 0;
        this.numberOfSix = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int getNumberOfBallsFaced() {
        return numberOfBallsFaced;
    }

    public void updateNumberOfBallsFaced() {
        this.numberOfBallsFaced++;
    }

    public int getNumberOfWicketsTaken() {
        return numberOfWicketsTaken;
    }

    public void updateNumberOfWicketsTaken() {
        numberOfWicketsTaken++;
    }

    public int getNumberOfFour() {
        return numberOfFour;
    }

    public void updateNumberOfFour() {
        this.numberOfFour++;
    }

    public int getNumberOfSix() {
        return numberOfSix;
    }

    public void updateNumberOfSix() {
        this.numberOfSix++;
    }

    public void updateScore(int run) {
        updateNumberOfBallsFaced();
        if (run == 4) {
            updateNumberOfFour();
        }
        if (run == 6) {
            updateNumberOfSix();
        }
        score = score + run;
    }

}
