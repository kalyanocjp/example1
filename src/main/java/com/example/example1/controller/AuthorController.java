package com.example.example1.controller;


import com.example.example1.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
