/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kl.todo.web.controller;

import com.kl.todo.domain.dao.JpaUserDao;
import com.kl.todo.domain.dao.UserDao;
import com.kl.todo.domain.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * @author kevin
 */
@Controller
@RequestMapping(value = "/signup")
public class SignupController {

    private UserDao userDao = new JpaUserDao();

    @RequestMapping(method=RequestMethod.GET)
    public String getCreateUser(Model model) {
        model.addAttribute(new User());
        return "signup/createForm";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "signup/createForm";
        }
        this.userDao.save(user);
        return "redirect:/signup/" + user.getId();
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public String getView(@PathVariable Long id, Model model) {
        User user = this.userDao.findUserById(new Long(1));
        model.addAttribute(user);
        return "signup/view";
    }
}
