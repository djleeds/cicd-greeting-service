package com.hitthebits.cicdexplore.greetingservice;

import com.hitthebits.greetingmodule.GreetingGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class App {

    private GreetingGenerator greetingGenerator;

    public App() {
        greetingGenerator = new GreetingGenerator();
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "{ \"greeting\": \"" + greetingGenerator.generate() + "\" }";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
