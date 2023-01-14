package com.aaron.todo.todoapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("login")
    public String goToLoginPage(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        logger.info("Request param is: " + name);
        return "login";
    }
}
