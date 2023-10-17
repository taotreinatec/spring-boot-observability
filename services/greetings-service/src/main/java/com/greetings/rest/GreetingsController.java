package com.greetings.rest;

import com.greetings.service.GreetingsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/greetings")
public class GreetingsController {

    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/hello")
    public String getHello() {
        String result = greetingsService.printHello();
        return result;
    }

    @GetMapping("/fortune")
    public String getFortune() {
        String result = greetingsService.printFortune();
        return result;
    }

}
