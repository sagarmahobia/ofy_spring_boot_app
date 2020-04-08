package com.ryf.appbackend.core.controller.open;


import com.ryf.appbackend.jpa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {

    @Autowired
    private UserDao userDao;

    @RequestMapping({"/app-*/**"})
    public String app() {
        return "forward:/index.html";
    }

}
