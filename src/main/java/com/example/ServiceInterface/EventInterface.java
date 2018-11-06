package com.example.ServiceInterface;

import com.example.Entity.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
/* alldeleted , allundeleted  */
@Service
public interface EventInterface {
    Iterable<Event> findAll();
    Optional<Event> findById(Long id);
    void AddEvent(Event evn , Long id);
    void DeleteEvent(Long id);
    void UpdateEvent(Event uevn);
    List<Event> ViewApprovedEvents();
    void ApproveEvent(Long id);

     List<Event> findByEventcity(String eventcity);
     List<Event> findByEventdate (LocalDate eventdate);
     List<Event> findByEventcityAndEventdate (String eventcity , LocalDate eventdate);
     List<Event> ViewDisapprovedEvents();
}

