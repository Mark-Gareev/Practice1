package ru.skillbench.tasks.basics.practice.rolladice;

import java.util.Scanner;

/**
 * class to describe gameplay of dice.
 * Have only one public method except constructor
 * @author Mark Gareev
 */
public class Game {
    /**
     * amount of players
     */
    private int N;
    /**
     * amount of dices
     */
    private int K;
    /**
     * array of players
     */
    private Player[] players;

    /**
     * constructor to set game parameters
     * @param n  -- number of players
     * @param k  -- amount of dices
     */
    public Game(int n, int k) {
        this.K = k;
        this.N = n;
        this.players = new Player[N];
    }

    /**
     * playing method united two private methods
     */
    public void start() {
        initialize();
        gaming();
    }

    /**
     * private method initializing players
     */
    private void initialize() {
        for (int i = 0; i < N - 1; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter name : ");
            //scan = scan.reset();
            players[i] = new Player(scan.nextLine());
            players[i].setBot(false);
        }
        players[N - 1] = new Player("computer");
        players[N - 1].setBot(true);
    }

    /**
     * game process, call oneRound method while one of the players will not win
     */
    private void gaming() {
        outer:
        {
            while (true) //check every player total score
            {
                oneRound();
                for (int i = 0; i < N; i++) {
                    if (players[i].getWinRoundsAmount() >= 7) {
                        System.out.println("\r\nPlayer " + players[i].getName() + " wins in this game!");
                        break outer;
                    }
                }
                System.out.println("\r\nNext round!\r\n");
            }
        }
    }

    /**
     * method describing one round of dice throwing.
     * Player rolls dices when push any key, bots rolls automatically
     */
    private void oneRound() {
        int[] playerScores = new int[N];
        StringBuilder uselessString = new StringBuilder(); // string to stop method until user pushes any key
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            if (players[i].isBot()) {
                System.out.println();
                playerScores[i] = playerRolling(i);
                continue;
            }
            System.out.println("\r\nPlayer " + players[i].getName() + "! Time to roll " + K + " dices! Press any key!");
            uselessString.append(scan.nextLine());
            playerScores[i] = playerRolling(i);
        }
        players[findMaximumIndex(playerScores)].oneScoreIncr();
        System.out.println("\r\n" + players[findMaximumIndex(playerScores)].getName() + " wins round!");
        swapPlayers(findMaximumIndex(playerScores), 0);
    }

    /**
     * describing player dice rolling, return player sum of dices
     *
     * @param index index in array of players
     * @return int sum of scores
     */
    private int playerRolling(int index) {
        int playerScores = 0;
        for (int j = 0; j < K; j++) {
            playerScores += players[index].rollaDice();
        }
        System.out.println("Player " + players[index].getName() + " has " + playerScores + " scores!");
        return playerScores;
    }

    /**
     * find index of biggest element
     *
     * @param array array to find max index
     * @return int index
     */
    private int findMaximumIndex(int[] array) {
        int check = array[0];
        int maxIndex = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (check < array[i]) {
                check = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * swap players in array of payers
     *
     * @param firstPlayerIndex
     * @param secondPlayerIndex
     */
    private void swapPlayers(int firstPlayerIndex, int secondPlayerIndex) {
        Player buffer;
        buffer = players[firstPlayerIndex];
        players[firstPlayerIndex] = players[secondPlayerIndex];
        players[secondPlayerIndex] = buffer;


    }
}
