package com.example.web2_myrestfulservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String HelloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-been")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("HelloWorld");
    }

    @GetMapping(path = "/hello-world-been/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}
