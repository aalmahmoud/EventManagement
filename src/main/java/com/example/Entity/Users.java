package com.example.Entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
@Table(name = "Users")

public class Users {

    public Users() {
    };


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long userid;

    @NotNull
    @Size(min = 2,max = 40)
    private String username;

    @NotBlank
    @NotNull
    private String userpassword;

    @Email
    @NotNull
    private String useremail;

    @NotNull
    private LocalDate userdob;

    @ManyToOne
    @JoinColumn(name="rolesid")
    private Roles rolesid;

    @ColumnDefault(value = "0")
    private  boolean deleted;

    @Size( max = 30)
    private String usercity;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public Roles getRolesid() {
        return rolesid;
    }

    public void setRolesid(Roles rolesid) {
        this.rolesid = rolesid;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getUsercity() {
        return usercity;
    }

    public void setUsercity(String usercity) {
        this.usercity = usercity;
    }

    public LocalDate getUserdob() {
        return userdob;
    }

    public void setUserdob(LocalDate userdob) {
        this.userdob = userdob;
    }
}

