package com.gmail.moroka.mrk.spring_boot_app.controller;

import com.gmail.moroka.mrk.spring_boot_app.game_manager.*;
import com.gmail.moroka.mrk.spring_boot_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/play/getGamesList")
public class GameController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @Autowired
    private GuessTheNumberManager guessTheNumberManager;

    @Autowired
    private OneHandBanditManager oneHandBanditManager;

    @Autowired
    private PlayingUserManager playingUserManager;


    @RequestMapping("")
    public String getGamesList(Model model) {
        model.addAttribute("currentPlayingUserId", playingUserManager.getPlayingUser().getId());
        model.addAttribute("currentPlayerBalance", playingUserManager.getPlayingUser().getBalance());
        return "games-list-view";
    }

    @RequestMapping("/playRoulette")
    public String playRoulette(Model model) {

        if (playingUserManager.getPlayingUser().getBalance() <= 0) {
            return "user-balance-is-empty";
        }
        model.addAttribute("rouletteManager", new RouletteManager());
        model.addAttribute("currentPlayerBalance", playingUserManager.getPlayingUser().getBalance());
        return "play-roulette-view";
    }

    @RequestMapping("/getSpinResult")
    public String getSpinResults(@ModelAttribute("rouletteManager") RouletteManager rouletteManager, Model model) {

        if (playingUserManager.getPlayingUser().getBalance() <= 0) {
            return "user-balance-is-empty";
        }

        int winAmount = rouletteManager.getSpinResultAmount();
        int playingUserId = (int) session.getAttribute("currentPlayingUserId");

        playingUserManager.addAmountAndSave(rouletteManager.getSpinResultAmount());

        model.addAttribute("rouletteManager", rouletteManager);
        model.addAttribute("playingUser", playingUserManager.getPlayingUser());

        return "roulette-win-color-view";
    }

    @RequestMapping("/playGuessTheNumber")
    public String playGuessTheNumber(Model model) {
        if (playingUserManager.getPlayingUser().getBalance() <= 0) {
            return "user-balance-is-empty";
        }
        model.addAttribute("guessTheNumberManager", guessTheNumberManager);
        model.addAttribute("currentPlayerBalance", playingUserManager.getPlayingUser().getBalance());
        return "play-guess-the-number-view";
    }


    @RequestMapping("/getGuessTheNumberResult")
    public String getGuessTheNumberResult(Model model,
                                          @ModelAttribute("guessTheNumberManager") GuessTheNumberManager guessTheNumberManager) {

        if (playingUserManager.getPlayingUser().getBalance() <= 0) {
            return "user-balance-is-empty";
        }

        int winNumber = guessTheNumberManager.generateWinningNumber();
        int chosenNumber = guessTheNumberManager.getChosenNumber();

        boolean isWin = (winNumber == chosenNumber);

        updateUserBalanceAfterGuessTheNumberSpin(isWin, guessTheNumberManager);

        model.addAttribute("isWin", isWin);
        model.addAttribute("guessTheNumberManager", guessTheNumberManager);
        model.addAttribute("balance", playingUserManager.getPlayingUser().getBalance());

        return "guess-the-number-win-number-view";
    }

    @RequestMapping("/playRussianRoulette")
    public String playRussianRoulette(Model model) {
        model.addAttribute("russianRouletteManager", new RussianRouletteManager());
        model.addAttribute("currentPlayerBalance", playingUserManager.getPlayingUser().getBalance());
        return "play-russian-roulette";
    }


    @RequestMapping("/getRussianRouletteSpinResult")
    public String getRussianRouletteSpinResult(
            @ModelAttribute("russianRouletteManager") RussianRouletteManager russianRouletteManager,
            Model model) {

        boolean isSuccess = russianRouletteManager.generateSpinResult();

        if (isSuccess) {

            russianRouletteManager.generateReward();
            playingUserManager.addAmountAndSave(russianRouletteManager.getReward());
            model.addAttribute("balance", playingUserManager.getPlayingUser().getBalance());

            return "russian-roulette-win-view";
        } else {
            userService.deleteUser(playingUserManager.getPlayingUser().getId());
            return "russian-roulette-loose-view";
        }

    }

    @RequestMapping("/playSimpleRoulette")
    private void updateUserBalanceAfterGuessTheNumberSpin(boolean isWin, GuessTheNumberManager guessTheNumberManager) {
        int bid = guessTheNumberManager.getBid();

        if (isWin) {
            playingUserManager.addAmountAndSave(bid * 3);
        } else {
            playingUserManager.withdrawAmountAndSave(bid);
        }
    }

    @RequestMapping("/playOneHandBandit")
    public String playOneHandBandit(Model model) {
        if (playingUserManager.getPlayingUser().getBalance() <= 0) {
            return "user-balance-is-empty";
        }
        model.addAttribute("oneHandBanditManager", oneHandBanditManager);
        model.addAttribute("currentPlayerBalance", playingUserManager.getPlayingUser().getBalance());
        return "play-one-hand-bandit-view";
    }

    @RequestMapping("/getOneHandBanditResult")
    public String getOneHandBanditResult(Model model,
                                         @ModelAttribute("oneHandBanditManager") OneHandBanditManager oneHandBanditManager){
        if (playingUserManager.getPlayingUser().getBalance() <= 0) {
            return "user-balance-is-empty";
        }

        oneHandBanditManager.fillDisplayList();
        int resultMoney = oneHandBanditManager.playAndGetWinMoney(oneHandBanditManager.getBid());
        playingUserManager.withdrawAmountAndSave(oneHandBanditManager.getBid());
        playingUserManager.addAmountAndSave(resultMoney);

        model.addAttribute("slotOne",oneHandBanditManager.getDisplayList().get(0));
        model.addAttribute("slotTwo",oneHandBanditManager.getDisplayList().get(1));
        model.addAttribute("slotThree",oneHandBanditManager.getDisplayList().get(2));
        model.addAttribute("slotFour",oneHandBanditManager.getDisplayList().get(3));
        model.addAttribute("slotFive",oneHandBanditManager.getDisplayList().get(4));
        model.addAttribute("resultMoney", resultMoney);
        model.addAttribute("currentPlayerBalance", playingUserManager.getPlayingUser().getBalance());

        return "one-hand-bandit-spin-result-view";
    }

}
