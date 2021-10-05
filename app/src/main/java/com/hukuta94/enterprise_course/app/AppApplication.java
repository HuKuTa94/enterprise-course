package com.hukuta94.enterprise_course.app;

import com.hukuta94.enterprise_course.core.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}

@RestController
class HelloWorldController {

    @GetMapping(path="/")
    public String hello() {
        return "{\"Message\": \"" + HelloWorld.getHello() +"\"}";
    }
}
