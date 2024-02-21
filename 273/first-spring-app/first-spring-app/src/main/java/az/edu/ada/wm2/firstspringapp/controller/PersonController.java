package az.edu.ada.wm2.firstspringapp.controller;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private Person defaultPerson;

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping
    public String listPersons(Model model){
        model.addAttribute("persons", List.of(
                new Person("Ali", "Aliyev"),
                new Person("Ali", "Aliyev"),
                new Person("Ali", "Aliyev"),
                new Person("Ali", "Aliyev")
        ));
        return "person_list";
    }
}
