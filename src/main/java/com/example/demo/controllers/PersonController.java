package com.example.demo.controllers;

import com.example.demo.Types.TypesPerson;
import com.example.demo.models.Development;
import com.example.demo.models.Order;
import com.example.demo.models.Person;
import com.example.demo.repo.OrderRepo;
import com.example.demo.repo.PersonRepo;
import org.assertj.core.internal.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private OrderRepo orderRepo;
    @GetMapping("/myinfo")
    public String SignInMain(Model model)
    {
        Person person = personRepo.findById(TypesPerson.ID).orElseThrow();

        model.addAttribute("name", person.getName());
        model.addAttribute("longname", person.getLongname());
        model.addAttribute("login", person.getLogin());
        model.addAttribute("password", person.getPassword());
        model.addAttribute("number", person.getNumber());


        return "myinfo";
    }

    @GetMapping("/about")
    public String About(Model model){


        return "about";
    }

    @PostMapping("/changepass")
    public String ChangePassword(@RequestParam String NewPassword,Model model){
        Person per = personRepo.findById(TypesPerson.ID).orElseThrow();
        per.setPassword(NewPassword);
        personRepo.save(per);

        model.addAttribute("name", per.getName());
        model.addAttribute("longname", per.getLongname());
        model.addAttribute("login", per.getLogin());
        model.addAttribute("password", per.getPassword());
        model.addAttribute("number", per.getNumber());
        return "myinfo";
    }

    @GetMapping("/contacts")
    public String Contacts(Model model){
        List<Person> persons = (List<Person>) personRepo.findAll();

for(int i = 0; i<persons.size();i++){


    if(persons.get(i).getDepnumber()==1){
        persons.get(i).setLogin("Разработка");

    }else if(persons.get(i).getDepnumber()==2){

        persons.get(i).setLogin("Маркетинг");

    }else if(persons.get(i).getDepnumber()==3){

        persons.get(i).setLogin("Генеральный Директор");

    }else if(persons.get(i).getDepnumber()==4){

        persons.get(i).setLogin("Финансы");

    }else if(persons.get(i).getDepnumber()==5){

        persons.get(i).setLogin("Эйчар");

    }

        }
        model.addAttribute("persons",persons);
        return "contacts";
    }

    @GetMapping("/stat")
    public String Stat(Model model){


        return "stat";
    }
    @GetMapping("/client")
    public String Client(Model model){


        return "client";
    }

    @PostMapping("/clientorder")
    public String ClientOrder(@RequestParam String NewOrderName,@RequestParam int NewCost, Model model){
        Order order = new Order(NewOrderName, NewCost,"Java","Не готов");
orderRepo.save(order);
        return "clientorder";
    }

}
