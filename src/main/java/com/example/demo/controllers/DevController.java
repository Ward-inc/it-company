package com.example.demo.controllers;


import com.example.demo.Types.TypesPerson;
import com.example.demo.models.Courses;
import com.example.demo.models.Development;
import com.example.demo.models.Order;
import com.example.demo.models.Person;
import com.example.demo.repo.CoursesRepo;
import com.example.demo.repo.DevRepo;
import com.example.demo.repo.OrderRepo;
import com.example.demo.repo.PersonRepo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class DevController {
    @Autowired
    private DevRepo devRepo;
    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/dev")
    public String dev(Model model){

        Development dev = devRepo.findById(TypesPerson.ID).orElseThrow();

        if(dev.getOrdernum()== 555){

            model.addAttribute("ordername", "У вас нет проектов");
            model.addAttribute("platform", "");
            model.addAttribute("status","");
        }else {
            Order order = orderRepo.findById(dev.getOrdernum()).orElseThrow();


            model.addAttribute("ordername", order.getOrdername());
            model.addAttribute("platform", order.getPlatform());
            model.addAttribute("status", order.getStatus());
        }
        return "dev";
    }

    @PostMapping("/dev")
    public String project(Model model){
        Development dev = devRepo.findById(TypesPerson.ID).orElseThrow();




        Order order2 = orderRepo.findById(dev.getOrdernum()).orElseThrow();
        order2.setStatus("Готов");
        orderRepo.save(order2);
        model.addAttribute("ordername", order2.getOrdername());
        model.addAttribute("platform", order2.getPlatform());
        model.addAttribute("status", order2.getStatus());



        return "/dev";
    }
}
