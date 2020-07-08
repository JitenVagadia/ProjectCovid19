package com.ita.covid.ProjectCovid19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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

    @Autowired
    CityInfoRepository cityInfoRepository;

    @Autowired
    StateInfoRepository stateInfoRepository;

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

        if(!personRepository.findById(person.getPersonContact()).isEmpty()){
            return "person already exists";
        }
        personRepository.save(person);
        if(cityInfoRepository.findById(person.getPersonCity()).isEmpty()){
            CityInfo cityInfo = new CityInfo(person.getPersonCity());
            if(person.isPersonDead()){
                cityInfo.setCityInfoDead(1);
            }
            if(person.isPersonRecovered()){
                cityInfo.setCityInfoRecovered(1);
            }
            cityInfoRepository.save(cityInfo);
        }
        else{
            try{
                CityInfo cityInfo = cityInfoRepository.findById(person.getPersonCity()).orElseThrow(() -> new ResourceNotFoundException("city not found :: " +person.getPersonCity() ));
                cityInfo.setCityInfoCases(cityInfo.getCityInfoCases()+1);
                if(person.isPersonDead()){
                    cityInfo.setCityInfoDead(cityInfo.getCityInfoDead()+1);
                }
                if(person.isPersonRecovered()){
                    cityInfo.setCityInfoRecovered(cityInfo.getCityInfoRecovered()+1);
                }
                cityInfoRepository.save(cityInfo);
            }
            catch(Exception e){
                System.out.println("oops.\n");
            }
        }

        if(stateInfoRepository.findById(person.getPersonState()).isEmpty()){
            StateInfo stateInfo = new StateInfo(person.getPersonState());
            if(person.isPersonDead()){
               stateInfo.setStateInfoDead(1);
            }
            if(person.isPersonRecovered()){
                stateInfo.setStateInfoRecovered(1);
            }
            stateInfoRepository.save(stateInfo);
        }
        else{
            try{
                StateInfo stateInfo = stateInfoRepository.findById(person.getPersonState()).orElseThrow(() -> new ResourceNotFoundException("state not found :: " +person.getPersonState() ));
                stateInfo.setStateInfoCases(stateInfo.getStateInfoCases()+1);
                if(person.isPersonDead()){
                    stateInfo.setStateInfoDead(stateInfo.getStateInfoDead()+1);
                }
                if(person.isPersonRecovered()){
                    stateInfo.setStateInfoRecovered(stateInfo.getStateInfoRecovered()+1);
                }
                stateInfoRepository.save(stateInfo);
            }
            catch(Exception e){
                System.out.println("oops.\n");
            }
        }
        return "something";
    }

    @PostMapping("/personupdate")
    public String UpdatePerson(@Valid @RequestBody Updateperson updateperson) throws ResourceNotFoundException {
        String contact = updateperson.contact;
        boolean dead = updateperson.dead;
        boolean recovered = updateperson.recovered;
        Person person = personRepository.findById(contact)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for contact :: " + contact));
        if(person.isPersonDead()!=dead){
            if(person.isPersonDead()==false){
                try{
                    CityInfo cityInfo = cityInfoRepository.findById(person.getPersonCity()).orElseThrow(() -> new ResourceNotFoundException("city not found :: " +person.getPersonCity() ));
                    cityInfo.setCityInfoDead(cityInfo.getCityInfoDead()+1);
                    cityInfoRepository.save(cityInfo);
                }
                catch(Exception e){
                    System.out.println("oops.\n");
                }
                try{
                    StateInfo stateInfo = stateInfoRepository.findById(person.getPersonState()).orElseThrow(() -> new ResourceNotFoundException("state not found :: " +person.getPersonState() ));
                    stateInfo.setStateInfoDead(stateInfo.getStateInfoDead()+1);
                    stateInfoRepository.save(stateInfo);
                }
                catch(Exception e){
                    System.out.println("oops.\n");
                }
            }
            else{
                try{
                    CityInfo cityInfo = cityInfoRepository.findById(person.getPersonCity()).orElseThrow(() -> new ResourceNotFoundException("city not found :: " +person.getPersonCity() ));
                    cityInfo.setCityInfoDead(cityInfo.getCityInfoDead()-1);
                    cityInfoRepository.save(cityInfo);
                }
                catch(Exception e){
                    System.out.println("oops.\n");
                }
                try{
                    StateInfo stateInfo = stateInfoRepository.findById(person.getPersonState()).orElseThrow(() -> new ResourceNotFoundException("state not found :: " +person.getPersonState() ));
                    stateInfo.setStateInfoDead(stateInfo.getStateInfoDead()-1);
                    stateInfoRepository.save(stateInfo);
                }
                catch(Exception e){
                    System.out.println("oops.\n");
                }
            }
        }
        if(person.isPersonRecovered()!=recovered){
            if(person.isPersonRecovered()==false){
                try{
                    CityInfo cityInfo = cityInfoRepository.findById(person.getPersonCity()).orElseThrow(() -> new ResourceNotFoundException("city not found :: " +person.getPersonCity() ));
                    cityInfo.setCityInfoRecovered(cityInfo.getCityInfoRecovered()+1);
                    cityInfoRepository.save(cityInfo);
                }
                catch(Exception e){
                    System.out.println("oops.\n");
                }
                try{
                    StateInfo stateInfo = stateInfoRepository.findById(person.getPersonState()).orElseThrow(() -> new ResourceNotFoundException("state not found :: " +person.getPersonState() ));
                    stateInfo.setStateInfoRecovered(stateInfo.getStateInfoRecovered()+1);
                    stateInfoRepository.save(stateInfo);
                }
                catch(Exception e){
                    System.out.println("oops.\n");
                }
            }
            else{
                try{
                    CityInfo cityInfo = cityInfoRepository.findById(person.getPersonCity()).orElseThrow(() -> new ResourceNotFoundException("city not found :: " +person.getPersonCity() ));
                    cityInfo.setCityInfoRecovered(cityInfo.getCityInfoRecovered()-1);
                    cityInfoRepository.save(cityInfo);
                }
                catch(Exception e){
                    System.out.println("oops.\n");
                }
                try{
                    StateInfo stateInfo = stateInfoRepository.findById(person.getPersonState()).orElseThrow(() -> new ResourceNotFoundException("state not found :: " +person.getPersonState() ));
                    stateInfo.setStateInfoRecovered(stateInfo.getStateInfoRecovered()-1);
                    stateInfoRepository.save(stateInfo);
                }
                catch(Exception e){
                    System.out.println("oops.\n");
                }
            }
        }
        person.setPersonDead(dead);
        person.setPersonRecovered(recovered);
        personRepository.save(person);
        return "Success";
    }

    @GetMapping("/report/state/{name}")
    public List<Person> reportState(@PathVariable(value="name") String state) {
        List<Person> people = personRepository.findByState(state);
        return people;
    }
    @GetMapping("/report/city/{name}")
    public List<Person> reportCity(@PathVariable(value="name") String city) {
        List<Person> people = personRepository.findByCity(city);
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

    @GetMapping("map/city")
    public List<CityInfo> getAllCities(){
        List<CityInfo> res = cityInfoRepository.findAll();
        return res;
    }
    @GetMapping("map/citymin")
    public List<CityInfoMin> getAllCitiesMin(){
        List<CityInfoMin> res = new ArrayList<CityInfoMin>();
        List<CityInfo> info = cityInfoRepository.findAll();
        for (CityInfo x : info){
            res.add(new CityInfoMin(x.getCityInfoCityName(),x.getCityInfoCases()));
        }
        return res;
    }

    @GetMapping("map/state")
    public List<StateInfo> getAllStates(){
        List<StateInfo> res = stateInfoRepository.findAll();
        return res;
    }
    @GetMapping("map/statemin")
    public List<StateInfoMin> getAllStatesMin(){
        List<StateInfoMin> res = new ArrayList<StateInfoMin>();
        List<StateInfo> info = stateInfoRepository.findAll();
        for (StateInfo x : info){
            res.add(new StateInfoMin(x.getStateInfoStateName(),x.getStateInfoCases()));
        }
        return res;
    }

    @GetMapping("report/{year}/{month}")
    public List<Person> personByDate(@PathVariable(value="year") String year,@PathVariable(value="month") String month){
        String q = year+"-"+month+"%";
        List<Person> res = personRepository.findByDate(q);
        return res;
    }
}


