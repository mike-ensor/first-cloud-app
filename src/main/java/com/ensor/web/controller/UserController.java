package com.ensor.web.controller;

import com.ensor.data.User;
import com.ensor.data.dao.UserDao;
import com.ensor.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String showUserInput(@ModelAttribute("model") UserModel userModel, Model model) {
        List<User> users = userDao.findAll();
        model.addAttribute("users", users);
        return "user/show";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String persist(@Valid @ModelAttribute("model") UserModel model, BindingResult bindingResult) {

        String view = "user/show";

        if (!bindingResult.hasErrors()) {

            User user = new User(model.getEmail());
            user.setFirstName(model.getFirstName());
            user.setLastName(model.getLastName());

            userDao.persist(user);

            view = "redirect:/user";
        }
        return view;
    }

}
