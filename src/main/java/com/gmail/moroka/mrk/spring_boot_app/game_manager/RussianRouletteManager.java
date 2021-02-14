package com.gmail.moroka.mrk.spring_boot_app.game_manager;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RussianRouletteManager {

    private int revolverClipBulletCount; //Bullet count chosen by player
    private int reward;
    private boolean isSpinResultSuccessful;
    private List<Integer> revolverClipBulletCountList;

    public RussianRouletteManager() {
        revolverClipBulletCountList = new ArrayList<>();
        revolverClipBulletCountList.add(1);
        revolverClipBulletCountList.add(2);
        revolverClipBulletCountList.add(3);
        revolverClipBulletCountList.add(4);
        revolverClipBulletCountList.add(5);
    }

    public List<Integer> getRevolverClipBulletCountList() {
        return revolverClipBulletCountList;
    }

    public void setRevolverClipBulletCountList(List<Integer> revolverClipBulletCountList) {
        this.revolverClipBulletCountList = revolverClipBulletCountList;
    }

    public int getRevolverClipBulletCount() {
        return revolverClipBulletCount;
    }

    public void setRevolverClipBulletCount(int revolverClipBulletCount) {
        this.revolverClipBulletCount = revolverClipBulletCount;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public boolean isSpinResultSuccessful() {
        return isSpinResultSuccessful;
    }

    public void setSpinResultSuccessful(boolean spinResultSuccessful) {
        isSpinResultSuccessful = spinResultSuccessful;
    }

    public boolean generateSpinResult() {
        int randomNumber = (int) (Math.random() * 6 + 1);
        if (randomNumber > revolverClipBulletCount) {
            isSpinResultSuccessful = true;
            return true;
        }
        isSpinResultSuccessful = false;
        return false;
    }

    public void generateReward(){
        if(revolverClipBulletCount == 1){
            reward = 500;
        } else if (revolverClipBulletCount == 2){
            reward = 1000;
        }else if(revolverClipBulletCount == 3){
            reward = 2000;
        }else if(revolverClipBulletCount == 4){
            reward = 5000;
        }else if(revolverClipBulletCount == 5){
            reward = 25000;
        }
    }

}
