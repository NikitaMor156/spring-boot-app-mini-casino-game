package com.gmail.moroka.mrk.spring_boot_app.game_manager;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GuessTheNumberManager {
    private int winningNumber;
    private List<Integer> bidList;
    private int bid;
    private int chosenNumber;

    public GuessTheNumberManager() {
        bidList = new ArrayList<>();
        bidList.add(0);
        bidList.add(10);
        bidList.add(50);
        bidList.add(100);
        bidList.add(250);
        bidList.add(1000);
        bidList.add(5000);
    }

    public int getChosenNumber() {
        return chosenNumber;
    }

    public void setChosenNumber(int chosenNumber) {
        this.chosenNumber = chosenNumber;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(int winningNumber) {
        this.winningNumber = winningNumber;
    }

    public List<Integer> getBidList() {
        return bidList;
    }

    public void setBidList(List<Integer> bidList) {
        this.bidList = bidList;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int generateWinningNumber() {
        winningNumber = (int) (Math.random() * 4 + 1); //random int [1;4]
        return winningNumber;
    }

}
