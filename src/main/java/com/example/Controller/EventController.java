package com.example.Controller;

import com.example.Entity.Event;
import com.example.ServiceInterface.EventInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping (value = "/api/Events")
@RestController
@CrossOrigin
public class EventController {
    @Autowired
    public EventInterface eventInterface;

    @RequestMapping(value = "/AllEvents", method = RequestMethod.GET)
    public Iterable<Event> getAllEvents(){ return eventInterface.findAll(); }

    @RequestMapping(value = "/FindEvents/{id}")
    public Optional<Event> findByIdd(@PathVariable Long id){return eventInterface.findById(id);}

    @PostMapping (value = "/AddEvents/{id}")
    public void AddEvent(@Valid @RequestBody Event evn, @PathVariable Long id) {/*BindingResult bindingResult)*/

       // if (bindingResult.hasErrors()){
            // need coding here
     //   }

        eventInterface.AddEvent(evn,id);
    }

    @PutMapping (value = "/UpdateEvent")
    public void UpdateEvent (@RequestBody Event uevn){eventInterface.UpdateEvent(uevn);}

    @PutMapping (value = "/DeleteEvent/{id}")
    public  void DeleteEvent (@PathVariable Long id){eventInterface.DeleteEvent(id);}

    @GetMapping  (value = "/ApprovedActiveEvents")
    public List<Event> ViewApprovedEvents () {return eventInterface.ViewApprovedEvents();}

    @GetMapping (value = "/DisapprovedEvents")
    public List<Event> ViewDisapprovedEvents(){return eventInterface.ViewDisapprovedEvents();}

    @PutMapping  (value = "/Approval/{id}")
    public void Approval (@PathVariable Long id) { eventInterface.ApproveEvent(id);}

    @GetMapping(value = "/City/{City}")
    public List<Event> findByEventcity (@PathVariable String City) {
        return eventInterface.findByEventcity(City);
    }
        @GetMapping (value = "/Date/{Edate}")
                public List<Event> findByEventdate  (@PathVariable  String Edate){
        return eventInterface.findByEventdate(LocalDate.parse(Edate)); }

        @GetMapping (value = "/CityAndDate/{city}/{date}")
    public List<Event> findByEventcityAndEventdate (@PathVariable String city,@PathVariable String date ){
        return eventInterface.findByEventcityAndEventdate(city,LocalDate.parse(date));
    }
}