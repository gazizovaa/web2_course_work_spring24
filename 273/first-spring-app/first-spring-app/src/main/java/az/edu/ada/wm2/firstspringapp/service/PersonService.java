package az.edu.ada.wm2.firstspringapp.service;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private List<Person> persons;

    public PersonService() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        persons.add(new Person());
        this.persons = new ArrayList<>(persons);
    }

    public void addPerson(Person person){
        if(person == null) return;
        if(person.getfName() == null ||  person.getfName().isBlank() ) return;
        if(person.getlName() == null ||  person.getlName().isBlank() ) return;

        persons.add(person);
    }

    public List<Person> listPersons(){
        return persons;
    }

    public void deletePerson(Integer idx){
        if(idx == null || idx < 0 || idx >= persons.size()) return;
        persons.remove(idx.intValue());
    }

}