package peaksoft.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main_Controller {
    @GetMapping()
    public String getMainPage(){
        return "mainPage";
    }
}
