package com.example.demo.controllers;

import com.example.demo.Types.TypesPerson;
import com.example.demo.models.Development;
import com.example.demo.models.Director;
import com.example.demo.models.Order;
import com.example.demo.models.Person;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MarkController {
@Autowired
private PersonRepo personRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private DevRepo devRepo;

    @PostMapping("/orderdev")
    public String orderdev(@RequestParam int IdDev, @RequestParam int IdOrder, Model model){

        Development dev = devRepo.findById(IdDev).orElseThrow();
        dev.setOrdernum(IdOrder);
       devRepo.save(dev);

        return "SignIn";
    }
    @GetMapping("/mark")
    public String SignInMain(Model model)
    {
        List<Person> devs = (List<Person>) personRepo.findAll();
        for(int i = 0; i<devs.size();i++) {


            if (devs.get(i).getIdperson() == 1) {
devs.get(i).setLogin("Java");
                model.addAttribute("devs",devs.get(i));
            }

        }



        Iterable<Order> orders =  orderRepo.findAll();
        model.addAttribute("orders",orders);
        return "mark";


    }

}
