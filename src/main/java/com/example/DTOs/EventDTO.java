package com.example.DTOs;

import com.example.Entity.Comment;
import com.example.Entity.Users;
import org.hibernate.annotations.ColumnDefault;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class EventDTO {

    @Size(min=2, max=40 /*message="Name should have atleast 2 characters"*/)
    private String eventname;

    private LocalDate eventdate;

    private long eventcapacity;

    private Users organizerid;

    private List<Comment> comment;

    private String eventcity;

    @ColumnDefault("0")
    private long ecounter;

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public LocalDate getEventdate() {
        return eventdate;
    }

    public void setEventdate(LocalDate eventdate) {
        this.eventdate = eventdate;
    }

    public long getEventcapacity() {
        return eventcapacity;
    }

    public void setEventcapacity(long eventcapacity) {
        this.eventcapacity = eventcapacity;
    }

    public Users getOrganizerid() {
        return organizerid;
    }

    public void setOrganizerid(Users organizerid) {
        this.organizerid = organizerid;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public String getEventcity() {
        return eventcity;
    }

    public void setEventcity(String eventcity) {
        this.eventcity = eventcity;
    }

    public long getEcounter() {
        return ecounter;
    }

    public void setEcounter(long ecounter) {
        this.ecounter = ecounter;
    }


}
