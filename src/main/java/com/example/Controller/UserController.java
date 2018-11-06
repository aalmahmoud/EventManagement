package com.example.Controller;
/* http://www.appsdeveloperblog.com/spring-mvc-postmapping-getmapping-putmapping-deletemapping/ */
import com.example.Entity.Users;
import com.example.ServiceImplementation.UserService;
import com.example.ServiceInterface.UsersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping (value = "/api/Users")
public class UserController {

    @Autowired
    public UsersInterface usersInterface;

    @RequestMapping (value = "/AllUsers", method = RequestMethod.GET)
    public Iterable<Users> getAllUsers(){ return usersInterface.findAll(); }

    @RequestMapping(value = "/FindUsers/{id}")
    public Optional<Users> findByIdd(@PathVariable Long id){return usersInterface.findById(id);}

    @PostMapping (value = "/AddUsers/{id}")
    public void AddUser(@Valid @RequestBody Users usr, @PathVariable Long id){
       usersInterface.AddUser(usr,id); }

       @PutMapping (value ="/UpdateUser/{rid}")
    public void UpdateUser(@Valid @RequestBody Users uusr,@PathVariable Long rid){
        usersInterface.UpdateUser(uusr,rid);
    }

    @PutMapping (value = "/DeleteUser/{id}")
    public void DeleteUser(@PathVariable Long id){usersInterface.DeleteUser(id);}
}