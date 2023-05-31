import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Club{
    private String name;
    private int points;
    private int wins;
    private int draws;
    private int loses;
    private int goalsScored;
    private int goalsConceded;
    ImageIcon icon;

    public Club(){
        this.name = "";
        points = 0;
        wins = 0;
        draws = 0;
        loses = 0;
    }

    public Club(String name){
        this.name = name;
        points = 0;
        wins = 0;
        draws = 0;
        loses = 0;

        // getting the icon for the club
        try{
            File iconFile = new File("src/Icons/" + name + ".png");
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(iconFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // getter and setters:


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getGoalDifference(){
        return goalsScored - goalsConceded;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    // methods:

    public void win(){
        points += 3;
        wins++;
    }

    public void draw(){
        points += 1;
        draws++;
    }



    public void lose(){
        loses++;
    }

    public boolean equals(Club team) {
        if (team.getName().equals(name)) return true;
        return false;
    }
}
