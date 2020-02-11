package com.ryf.appbackend.core.opportunity;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {

    @RequestMapping({"/app-*"})
    public String app() {
        return "forward:/index.html";
    }

}
