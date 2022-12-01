package com.example.demo.controllers;

import com.example.demo.Types.TypesPerson;
import com.example.demo.models.Development;
import com.example.demo.models.Director;
import com.example.demo.models.Person;
import com.example.demo.repo.DevRepo;
import com.example.demo.repo.DirRepo;
import com.example.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DirController {
    @Autowired
    private DirRepo dirRepo;
    @Autowired
    private PersonRepo personRepo;
    @GetMapping("/director")
    public String dir(Model model){
        Director dev = dirRepo.findById(TypesPerson.ID).orElseThrow();
        Iterable<Person> persons =  personRepo.findAll();
        model.addAttribute("persons",persons);
        return "director";
    }

    @PostMapping("/director/{id}")
    public String dir_del(@PathVariable(value = "id") int id, Model model){
Person person = personRepo.findById(id).orElseThrow();
personRepo.delete(person);
        Director dev = dirRepo.findById(TypesPerson.ID).orElseThrow();
        Iterable<Person> persons =  personRepo.findAll();
        model.addAttribute("persons",persons);
        return "director";
    }

}
