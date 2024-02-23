package az.edu.ada.wm2.firstspringapp.controller;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private List<Person> persons = List.of(
            new Person("Ali", "Aliyev"),
            new Person("Ali", "Aliyev"),
            new Person("Ali", "Aliyev"),
            new Person("Ali", "Aliyev")
    );
    @Autowired
    private Person defaultPerson;

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping({"", "/"})
    public String listPersons(Model model){
        model.addAttribute("persons", List.of(
                new Person("Ali", "Aliyev"),
                new Person("Ali", "Aliyev"),
                new Person("Ali", "Aliyev"),
                new Person("Ali", "Aliyev")
        ));

        return;
    }

    @GetMapping("/new")
    public String newForm(Model model){
        model.addAttribute("person", new Person(" ", " "));
        return "new_person_form";
    }

    @PostMapping("/save")
    public String savePerson(Model model, @ModelAttribute("person") Person newPerson){
        this.persons.add(newPerson);
        return "redirect:/persons";
    }
}
