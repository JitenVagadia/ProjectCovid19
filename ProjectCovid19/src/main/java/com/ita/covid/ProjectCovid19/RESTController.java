package com.ita.covid.ProjectCovid19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RESTController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    HelperRepository helperRepository;

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
    public String AddPerson(@Valid @RequestBody Person person){
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

    @GetMapping("/reportState/{name}")
    public List<Person> repoState(@PathVariable(value="name") String state) {
        List<Person> people = personRepository.findByState(state);
        return people;
    }


    @GetMapping("/help/{city}")
    public ResponseEntity<List<Helper>> getHelp(@PathVariable(value="city") String city) throws ResourceNotFoundException {

        List<Helper> helpers = helperRepository.findHelperByCity(city);
        return ResponseEntity.ok().body(helpers);
    }

    @PostMapping("/help")
    public void AddHelper(@Valid @RequestBody Helper helper){

        helperRepository.save(helper);
    }

    @DeleteMapping("help/{contact}")
    public String DeleteHelper(@PathVariable(value="contact") String contact){

        helperRepository.deleteById(contact);
        return "delete successful";
    }
}


