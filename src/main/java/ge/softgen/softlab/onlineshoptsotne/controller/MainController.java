package ge.softgen.softlab.onlineshoptsotne.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String getHelloMessage(){
        return "This is homepage";
    }

}
