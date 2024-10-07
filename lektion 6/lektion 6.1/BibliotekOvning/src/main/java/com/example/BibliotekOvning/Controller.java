package com.example.BibliotekOvning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/getAllBooks")
    public String getAllBooks() {
        return "Hello World";
    }

    @PostMapping("/addBook")
    public String addBook (){
        return "Hello World";
    }

    @PostMapping("/updateBook")
    public String updateBook(){
        return "Hello World";
    }

    @PostMapping("/deleteBooks")
    public String deleteBooks(){
        return "Hello World";
    }


}
