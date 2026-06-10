package com.proj1.spring1proj;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping()//The 'homepage' (no arguments for
    public String Message(){
        return "Welcome to homepage";
    }

    @GetMapping("/greet")
        public String hello(){
            return "Hello, Bongani";
        }


}
