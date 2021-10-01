package com.gmail.moroka.mrk.spring_boot_app.game_manager;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

// * # $
// *** -> bid x 0.25    ### - bid x 1       $$$ - bid x 3
// **** -> bid x 1.5    #### - bid x 2.5    $$$$ - bid x 15
// ****** -> bid x 2.5  ##### - bid x 5     $$$$$ - bid x 100
@Component
public class OneHandBanditManager {

    private int bid;
    private int displaySize; //5
    private ArrayList<String> displayList;
    private int winMoney;

    public OneHandBanditManager() {
        displaySize = 5;
        winMoney = 0;
        displayList = new ArrayList<>(displaySize);
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public ArrayList<String> getDisplayList() {
        return displayList;
    }

    public void setDisplayList(ArrayList<String> displayList) {
        this.displayList = displayList;
    }

    public int getWinMoney() {
        return winMoney;
    }

    public void setWinMoney(int winMoney) {
        this.winMoney = winMoney;
    }

    public int playAndGetWinMoney(int bid) {
        this.bid = bid;
        int winMoney = getMoneyFromStars() + getMoneyFromHashes() + getMoneyFromDollars();
        return winMoney;
    }

    public void fillDisplayList() {
        for (int i = 0; i < displaySize; i++) {
            displayList.add(generateCharacter());
        }
    }

    private String generateCharacter() {
        int numberOfCharacter = (int) (Math.random() * 3);
        if (numberOfCharacter == 0) {
            return "*";
        }
        if (numberOfCharacter == 1) {
            return "#";
        }
        if (numberOfCharacter == 2) {
            return "$";
        }
        return "ERROR";
    }

    public String getDisplayListPrint(){
        String displayPrint ="[";
        for(int i=0;i<displayList.size();i++){
            displayPrint += displayList.get(i) + " ,";
        }
        displayPrint += "]";
        return displayPrint;
    }

    private int getMoneyFromStars() {
        int count = getCountOfSequentialStars();
        if (count < 3) {
            return 0;
        }
        if (count == 3) {
            return ((int) (bid * 0.25));
        }
        if (count == 4) {
            return ((int) (bid * 1.5));
        }
        if (count == 5) {
            return ((int) (bid * 2.5));
        }
        return 0;
    }

    private int getMoneyFromHashes() {
        int count = getCountOfSequentialHashes();
        if (count < 3) {
            return 0;
        }
        if (count == 3) {
            return (bid);//*1
        }
        if (count == 4) {
            return ((int) (bid * 2.5));
        }
        if (count == 5) {
            return (bid * 5);
        }
        return 0;
    }

    private int getMoneyFromDollars() {
        int count = getCountOfSequentialDollars();
        if (count < 3) {
            return 0;
        }
        if (count == 3) {
            return (bid * 3);
        }
        if (count == 4) {
            return (bid * 15);
        }
        if (count == 5) {
            return (bid * 100);
        }
        return 0;
    }

    private int getCountOfSequentialStrings(String str) {
        ArrayList<Integer> comboList = new ArrayList<>();
        int combo = 0;
        for (int i = 0; i < displayList.size(); i++) {
            if (displayList.get(i).equals(str)) {
                combo += 1;
            } else {
                if (combo != 0) {
                    comboList.add(combo);
                    combo = 0;
                }
            }
        }
        if(combo > 0){
            comboList.add(combo);
        }
        if (comboList.size() == 0) {
            return 0;
        }
        return getMaxIntegerFromArrayList(comboList);
    }

    private int getCountOfSequentialStars() {
        return getCountOfSequentialStrings("*");
    }

    private int getCountOfSequentialHashes() {
        return getCountOfSequentialStrings("#");
    }

    private int getCountOfSequentialDollars() {
        return getCountOfSequentialStrings("$");
    }

    private int getMaxIntegerFromArrayList(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 0) {
            return 0;
        }
        int max = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > max) {
                max = arrayList.get(i);
            }
        }
        return max;
    }

}
