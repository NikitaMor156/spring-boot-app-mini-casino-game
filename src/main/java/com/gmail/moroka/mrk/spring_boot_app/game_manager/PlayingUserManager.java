package com.gmail.moroka.mrk.spring_boot_app.game_manager;

import com.gmail.moroka.mrk.spring_boot_app.entity.User;
import com.gmail.moroka.mrk.spring_boot_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class PlayingUserManager {

    private User playingUser;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    public User getPlayingUser() {
        updatePlayingUser();
        return playingUser;
    }

    private void updatePlayingUser() {
        try {
            int id = (int) session.getAttribute("currentPlayingUserId");
            playingUser = userService.getUser(id);
        } catch (NullPointerException e) {
            System.out.println("Uncritical error (but it mustn't break a program)");
        }
    }

    public void addAmountAndSave(int amount) {
        updatePlayingUser();
        playingUser.setBalance(playingUser.getBalance() + amount);
        userService.saveUser(playingUser);

    }

    public void withdrawAmountAndSave(int amount) {
        updatePlayingUser();
        playingUser.setBalance(playingUser.getBalance() - amount);
        userService.saveUser(playingUser);
    }


}
