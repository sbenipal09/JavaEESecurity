package sin12743.securityexample1.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecurityController {

    @GetMapping(value = {"/"})
    public String goHome(){

        return  "home";
    }



    @GetMapping("/user")
        public String goUser(){
            return "user";
        }

    @GetMapping("/Multiple")
    public String goMultiple(){
        return "Multiple";
    }

    @GetMapping("/logintem")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/accessdenied")
        public String accessDenied(){
            return "accessdenied";
        }
    }

