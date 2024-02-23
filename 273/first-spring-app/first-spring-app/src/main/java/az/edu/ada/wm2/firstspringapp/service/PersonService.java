package az.edu.ada.wm2.firstspringapp.service;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    public void addPerson(Person person){
        if(person == null) return;
        if(person.getfName() == null || person.getfName().isBlank()) return;
        if(person.getlName() == null || person.getlName().isBlank()) return;

        return person.add(persons);
    }


    public List<Person> listPersons(){
        return persons;
    }

    public void deletePerson(Person person){

    }
}
