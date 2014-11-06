package net.bradproctor.ngspringplate.controller;

import net.bradproctor.ngspringplate.dto.User;
import net.bradproctor.ngspringplate.exception.WebException;
import net.bradproctor.ngspringplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users")
    public @ResponseBody
    List<User> getUsers() throws WebException {
        List<User> users;

        try {
            users = userService.getUsers();
        } catch (Exception e) {
            throw new WebException("Exception retrieving user", e);
        }
        return users;
    }
}
