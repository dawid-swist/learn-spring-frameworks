package dev.n9mac.pharaoh.learncorespringframework.ch00;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class WebController {

    @GetMapping
    public String salutation() {
        return "Hello world!";
    }
}