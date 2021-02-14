package com.gmail.moroka.mrk.spring_boot_app.controller;

import com.gmail.moroka.mrk.spring_boot_app.entity.User;
import com.gmail.moroka.mrk.spring_boot_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    HttpSession session;

    @RequestMapping("/")
    public String getView(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "starter-page-view";
    }


    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){

        User user = new User();
        model.addAttribute("user",user);

        return "add-new-user-view";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id){
    userService.deleteUser(id);
    return "redirect:/";
    }

    @RequestMapping("/chooseUser")
    public String chooseUser(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "choose-user-view";
    }

    @RequestMapping("/writeChosenUserToSession")
    public String writeChosenUserToSession(@RequestParam("playerId") int playerId){
        session.setAttribute("currentPlayingUserId", playerId);
        return "redirect:/play/getGamesList";
    }

}
