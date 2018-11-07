package com.example.Entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "Roles")
public class Roles {

    public Roles(){}


    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    private  long rolesid;

    private String rolesname;

    @ColumnDefault("0")
    private  boolean deleted ;

    public long getRolesid() {
        return rolesid;
    }

    public void setRolesid(long rolesid) {
        this.rolesid = rolesid;
    }

    public String getRolesname() {
        return rolesname;
    }

    public void setRolesname(String rolesname) {
        this.rolesname = rolesname;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
