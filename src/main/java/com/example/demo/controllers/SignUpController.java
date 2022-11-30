package com.example.demo.controllers;



import com.example.demo.Types.TypesPerson;
import com.example.demo.Types.TypesPerson;
import com.example.demo.models.Development;
import com.example.demo.models.Person;
import com.example.demo.repo.DevRepo;
import com.example.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Optional;

@Controller
public class SignUpController {

    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private DevRepo devRepo;

    @GetMapping("/")
    public String SignInMain(Model model)
    {
        return "SignIn";
    }

    @PostMapping("/SignIn")
    public String SignIn(@RequestParam String username, @RequestParam String password, Model model)
    {
        Iterable<Person> persons = personRepo.findAll();
        boolean isAdmin = false;
        for (Person person : persons) {
            if(person.getLogin().equals(username) && person.getPassword().equals(password)){
                int i = person.getDepnumber();

                TypesPerson.ID = person.getIdperson();
                TypesPerson.NAME = person.getName();
                TypesPerson.LONGNAME = person.getLongname();
                TypesPerson.NUMBER = person.getNumber();
                TypesPerson.LOGIN = person.getLogin();
                TypesPerson.PASSWORD = person.getPassword();
                TypesPerson.DEPNUMBER = person.getDepnumber();

                switch (i){
                    case 1:{


                        return "redirect:/dev";
                    }
                    case 2:{


                        return "redirect:/mark";
                    }
                    case 3:{



                        return "redirect:/director";
                    }
                    case 4:{


                        return "redirect:/fin";
                    }
                    case 5:{


                        return "redirect:/hr";
                    }
                }

            }
        }

        return "redirect:/login";
    }
}
