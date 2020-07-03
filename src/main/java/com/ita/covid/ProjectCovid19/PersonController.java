package com.ita.covid.ProjectCovid19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAllPerson(){
        List<Person> people = personRepository.findAll();
        return people;
    }
    @GetMapping("/person/{contact}")
    public ResponseEntity<Person> getPerson(@PathVariable(value="contact") String contact) throws ResourceNotFoundException {
        Person person = personRepository.findById(contact)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for contact :: " + contact));
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("/person")
    public String AddPerson(@RequestBody Person person){
        //validation
        personRepository.save(person);
        return "something";
    }

    @PutMapping("/person/{contact}")
    public String UpdatePerson(@PathVariable(value="contact") String contact,@RequestParam(name="dead", required=true) boolean dead,@RequestParam(name="recovered", required=true) boolean recovered) throws ResourceNotFoundException {

        Person person = personRepository.findById(contact)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for contact :: " + contact));

        person.setPersonDead(dead);
        person.setPersonRecovered(recovered);
        return "Success";
    }

}
