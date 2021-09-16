package com.gmail.moroka.mrk.spring_boot_app.game_manager;


import java.util.Arrays;

public class SimpleRouletteManager {
    private int bid;
    private double winBid;
    private double[] bidArr;
    private int winNumber; // in model
    private  double winCoef; //in model

    public SimpleRouletteManager(int bid) {
        this.bid = bid;
        bidArr = new double[5];
        bidArr[0] = 0.;
        bidArr[1] = 0.5;
        bidArr[2] = 1.;
        bidArr[3] = 2.;
        bidArr[4] = 4.;

    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public double getWinBid() {
        return winBid;
    }

    public void setWinBid(double winBid) {
        this.winBid = winBid;
    }

    public double[] getBidArr() {
        return bidArr;
    }

    public void setBidArr(double[] bidArr) {
        this.bidArr = bidArr;
    }

    public int getWinNumber() {
        return winNumber;
    }

    public void setWinNumber(int winNumber) {
        this.winNumber = winNumber;
    }

    public double getWinCoef() {
        return winCoef;
    }

    public void setWinCoef(double winCoef) {
        this.winCoef = winCoef;
    }

    public int getGameResult() {
        winNumber = (int) (Math.random() * 5);
        winCoef = bidArr[winNumber];
        winBid = bid * winCoef;

        return winNumber;
    }

    @Override
    public String toString() {
        return "SimpleRouletteManager{" +
                "bid=" + bid +
                ", winBid=" + winBid +
                ", bidArr=" + Arrays.toString(bidArr) +
                ", winNumber=" + winNumber +
                ", winCoef=" + winCoef +
                '}';
    }
}
