package ru.skillbench.tasks.basics.practice.rolladice;

/**
 * class to describe dice player.
 * @author Mark Gareev
 */
public class Player {
    private int WinRoundsAmount;
    private String name;
    private boolean isBot;
    public Player(String name){
        this.name = name;
        this.WinRoundsAmount = 0;
    }

    /**
     * simulate hex dice rolling
     * @return score of one dice
     */
    public int rollaDice(){
        return (int)(Math.random() * 7 + 1);
    }
    public void oneScoreIncr(){
        this.WinRoundsAmount++;
    }
    public int getWinRoundsAmount(){
        return this.WinRoundsAmount;
    }

    public String getName() {
        return name;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public boolean isBot() {
        return isBot;
    }
}
