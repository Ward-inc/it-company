package com.example.demo.controllers;

import com.example.demo.Types.TypesPerson;
import com.example.demo.models.*;
import com.example.demo.repo.CoursesRepo;
import com.example.demo.repo.HrRepo;
import com.example.demo.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HrController {
@Autowired
private HrRepo hrRepo;
    @Autowired
    private CoursesRepo coursesRepo;
    @GetMapping("/hr")
    public String SignInMain(Model model)
    {
        HR hr = hrRepo.findById(TypesPerson.ID).orElseThrow();
        if(hr.getCoursesnum()== 0){

            model.addAttribute("coursesname", "У вас нет курсов");
            model.addAttribute("budget", "");
            model.addAttribute("studentsnum","");
        }else {
            Courses courses = coursesRepo.findById(hr.getCoursesnum()).orElseThrow();


            model.addAttribute("coursesname", courses.getCoursesname());
            model.addAttribute("budget", courses.getBudget());
            model.addAttribute("studentsnum", courses.getStudentsnum());
        }



        Iterable<Courses> courses =  coursesRepo.findAll();
        model.addAttribute("courses",courses);



        return "hr";
    }

    @PostMapping("/hr")
    public String HrDeleteCourse(Model model)
    {
       HR hr = hrRepo.findById(TypesPerson.ID).orElseThrow();





        hr.setCoursesnum(0);
       hrRepo.save(hr);

        HR hrr = hrRepo.findById(TypesPerson.ID).orElseThrow();
        if(hrr.getCoursesnum()== 0){

            model.addAttribute("coursesname", "У вас нет курсов");
            model.addAttribute("budget", "");
            model.addAttribute("studentsnum","");
        }else {
            Courses courses = coursesRepo.findById(hr.getCoursesnum()).orElseThrow();


            model.addAttribute("coursesname", courses.getCoursesname());
            model.addAttribute("budget", courses.getBudget());
            model.addAttribute("studentsnum", courses.getStudentsnum());
        }

        HR hr1 = hrRepo.findById(TypesPerson.ID).orElseThrow();
        if(hr1.getCoursesnum()== 0){

            model.addAttribute("coursesname", "У вас нет курсов");
            model.addAttribute("budget", "");
            model.addAttribute("studentsnum","");
        }else {
            Courses courses = coursesRepo.findById(hr1.getCoursesnum()).orElseThrow();


            model.addAttribute("coursesname", courses.getCoursesname());
            model.addAttribute("budget", courses.getBudget());
            model.addAttribute("studentsnum", courses.getStudentsnum());
        }



        Iterable<Courses> courses =  coursesRepo.findAll();
        model.addAttribute("courses",courses);
        return "hr";
    }

    @PostMapping("/hr/{id}")
    public String hr_cour(@PathVariable(value = "id") int id, Model model){

        HR hr1 = hrRepo.findById(TypesPerson.ID).orElseThrow();
        hr1.setCoursesnum(id);
        hrRepo.save(hr1);

        HR hr = hrRepo.findById(TypesPerson.ID).orElseThrow();
        if(hr.getCoursesnum()== 0){

            model.addAttribute("coursesname", "У вас нет курсов");
            model.addAttribute("budget", "");
            model.addAttribute("studentsnum","");
        }else {
            Courses courses = coursesRepo.findById(hr.getCoursesnum()).orElseThrow();


            model.addAttribute("coursesname", courses.getCoursesname());
            model.addAttribute("budget", courses.getBudget());
            model.addAttribute("studentsnum", courses.getStudentsnum());
        }



        Iterable<Courses> courses =  coursesRepo.findAll();
        model.addAttribute("courses",courses);


        return "hr";
    }
}
