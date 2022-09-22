package com.example.web2_myrestfulservice;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calculate/")
@RestController
public class CalculateController {

    @GetMapping("/add/{a}/{b}")
    public Object add(@PathVariable("a") int a, @PathVariable("b") int b, Model model) {
        return ResponseEntity.ok(model.addAttribute("result", a+b));
    }
    @GetMapping("/minus/{a}/{b}")
    public Object minus(@PathVariable("a") int a, @PathVariable("b") int b, Model model) {
        return ResponseEntity.ok(model.addAttribute("result", a-b));
    }
    @GetMapping("/multiply/{a}/{b}")
    public Object multiply(@PathVariable("a") int a, @PathVariable("b") int b, Model model) {
        return ResponseEntity.ok(model.addAttribute("result", a*b));
    }
    @GetMapping("/divide/{a}/{b}")
    public Object divide(@PathVariable("a") float a, @PathVariable("b") float b, Model model) {
        return ResponseEntity.ok(model.addAttribute("result", a/b));
    }



}
