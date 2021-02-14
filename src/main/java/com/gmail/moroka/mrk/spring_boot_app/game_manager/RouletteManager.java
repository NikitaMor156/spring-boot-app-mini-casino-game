package com.gmail.moroka.mrk.spring_boot_app.game_manager;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouletteManager {

    private List<Integer> redBidList;
    private List<Integer> blackBidList;
    private List<Integer> greenBidList;
    private int redBid;
    private int blackBid;
    private int greenBid;
    int winnerColor;


    public RouletteManager() {
        redBidList = new ArrayList<>();
        blackBidList = new ArrayList<>();
        greenBidList = new ArrayList<>();

        fillRedBidList();
        fillBlackBidList();
        fillGreenBidList();
    }

    public List<Integer> getRedBidList() {
        return redBidList;
    }

    public void setRedBidList(List<Integer> redBidList) {
        this.redBidList = redBidList;
    }

    public List<Integer> getBlackBidList() {
        return blackBidList;
    }

    public void setBlackBidList(List<Integer> blackBidList) {
        this.blackBidList = blackBidList;
    }

    public List<Integer> getGreenBidList() {
        return greenBidList;
    }

    public void setGreenBidList(List<Integer> greenBidList) {
        this.greenBidList = greenBidList;
    }

    public int getRedBid() {
        return redBid;
    }

    public void setRedBid(int redBid) {
        this.redBid = redBid;
    }

    public int getBlackBid() {
        return blackBid;
    }

    public void setBlackBid(int blackBid) {
        this.blackBid = blackBid;
    }

    public int getGreenBid() {
        return greenBid;
    }

    public void setGreenBid(int greenBid) {
        this.greenBid = greenBid;
    }

    public int getWinnerColor() {
        return winnerColor;
    }

    public void setWinnerColor(int winnerColor) {
        this.winnerColor = winnerColor;
    }

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

    private int generateGameResult() {
        int a = (int) (Math.random() * 100);
        if (a >= 0 && a <= 44) {
            winnerColor = 1;
            return winnerColor; //RED win
        }
        if (a >= 45 && a <= 89) {
            winnerColor = 2;
            return winnerColor; //BLACK win
        }
        if (a >= 90 && a <= 100) {
            winnerColor = 3;
            return winnerColor; //GREEN win
        }
        return -1;
    }

    public int getSpinResultAmount() {
        int winColor = generateGameResult();
        int totalBidAmount = redBid + blackBid + greenBid;
        int winAmount = 0;

        if (winColor == 1) {
            winAmount = redBid * 2;
        } else if (winColor == 2) {
            winAmount = blackBid * 2;
        } else if (winColor == 3) {
            winAmount = greenBid * 5;
        } else if (winColor == -1) {
            return 0;
        }
        return (winAmount - totalBidAmount);
    }
}
