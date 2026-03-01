package com.gmail.moroka.mrk.spring_boot_app.game_manager;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RouletteManager {

    private static final Set<Integer> RED_NUMBERS = new HashSet<>(Arrays.asList(
            1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));

    private List<Integer> redBidList;
    private List<Integer> blackBidList;
    private List<Integer> greenBidList;
    private List<Integer> numberBidList;

    private int redBid;
    private int blackBid;
    private int greenBid;
    private int numberBid;
    private int chosenNumber;

    int winnerColor;
    private int winnerNumber;


    public RouletteManager() {
        redBidList    = new ArrayList<>();
        blackBidList  = new ArrayList<>();
        greenBidList  = new ArrayList<>();
        numberBidList = new ArrayList<>();

        fillRedBidList();
        fillBlackBidList();
        fillGreenBidList();
        fillNumberBidList();

        chosenNumber = -1;
        numberBid    = 0;
    }

    // ------------------------------------------------------------------ fills

    public void fillRedBidList() {
        redBidList.add(0);
        redBidList.add(10);
        redBidList.add(50);
        redBidList.add(100);
        redBidList.add(250);
        redBidList.add(1000);
        redBidList.add(5000);
    }

    public void fillBlackBidList() {
        blackBidList.add(0);
        blackBidList.add(10);
        blackBidList.add(50);
        blackBidList.add(100);
        blackBidList.add(250);
        blackBidList.add(1000);
        blackBidList.add(5000);
    }

    public void fillGreenBidList() {
        greenBidList.add(0);
        greenBidList.add(10);
        greenBidList.add(50);
        greenBidList.add(100);
        greenBidList.add(250);
        greenBidList.add(1000);
        greenBidList.add(5000);
    }

    public void fillNumberBidList() {
        numberBidList.add(0);
        numberBidList.add(10);
        numberBidList.add(50);
        numberBidList.add(100);
        numberBidList.add(250);
        numberBidList.add(1000);
        numberBidList.add(5000);
    }

    // ------------------------------------------------------------------ game logic

    /** Picks a random number 0-36, then derives the winning color from it. */
    private void generateGameResult() {
        winnerNumber = (int) (Math.random() * 37); // 0..36 inclusive
        if (winnerNumber == 0) {
            winnerColor = 3; // GREEN
        } else if (RED_NUMBERS.contains(winnerNumber)) {
            winnerColor = 1; // RED
        } else {
            winnerColor = 2; // BLACK
        }
    }

    /**
     * Spins the wheel and returns the net balance change for the player.
     * Color bets: RED/BLACK pay x2, GREEN pays x5.
     * Number bet: pays 35:1 (net +35× bid on win, −bid on loss).
     */
    public int getSpinResultAmount() {
        generateGameResult();

        int totalBidAmount = redBid + blackBid + greenBid + numberBid;
        int winAmount = 0;

        if (winnerColor == 1) {
            winAmount += redBid * 2;
        } else if (winnerColor == 2) {
            winAmount += blackBid * 2;
        } else if (winnerColor == 3) {
            winAmount += greenBid * 5;
        }

        if (chosenNumber >= 0 && numberBid > 0 && winnerNumber == chosenNumber) {
            winAmount += 36 * numberBid; // 36x returned; minus the 1x already in totalBidAmount = net 35x
        }

        return winAmount - totalBidAmount;
    }

    // ------------------------------------------------------------------ getters / setters

    public List<Integer> getRedBidList() { return redBidList; }
    public void setRedBidList(List<Integer> redBidList) { this.redBidList = redBidList; }

    public List<Integer> getBlackBidList() { return blackBidList; }
    public void setBlackBidList(List<Integer> blackBidList) { this.blackBidList = blackBidList; }

    public List<Integer> getGreenBidList() { return greenBidList; }
    public void setGreenBidList(List<Integer> greenBidList) { this.greenBidList = greenBidList; }

    public List<Integer> getNumberBidList() { return numberBidList; }
    public void setNumberBidList(List<Integer> numberBidList) { this.numberBidList = numberBidList; }

    public int getRedBid() { return redBid; }
    public void setRedBid(int redBid) { this.redBid = redBid; }

    public int getBlackBid() { return blackBid; }
    public void setBlackBid(int blackBid) { this.blackBid = blackBid; }

    public int getGreenBid() { return greenBid; }
    public void setGreenBid(int greenBid) { this.greenBid = greenBid; }

    public int getNumberBid() { return numberBid; }
    public void setNumberBid(int numberBid) { this.numberBid = numberBid; }

    public int getChosenNumber() { return chosenNumber; }
    public void setChosenNumber(int chosenNumber) { this.chosenNumber = chosenNumber; }

    public int getWinnerColor() { return winnerColor; }
    public void setWinnerColor(int winnerColor) { this.winnerColor = winnerColor; }

    public int getWinnerNumber() { return winnerNumber; }
    public void setWinnerNumber(int winnerNumber) { this.winnerNumber = winnerNumber; }
}
