package com.example.Controller;
/* http://www.appsdeveloperblog.com/spring-mvc-postmapping-getmapping-putmapping-deletemapping/ */
import com.example.DTOs.UserDTO;
import com.example.Entity.Users;
import com.example.ServiceImplementation.UserService;
import com.example.ServiceInterface.UsersInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping (value = "/api/Users")
public class UserController {

    @Autowired
    public UsersInterface usersInterface;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping (value = "/AllUsers", method = RequestMethod.GET)
    public Iterable<Users> getAllUsers(){ return usersInterface.findAll(); }

    @RequestMapping(value = "/FindUsers/{id}")
    public Optional<Users> findByIdd(@PathVariable Long id){return usersInterface.findById(id);}

    @PostMapping (value = "/AddUsers/{id}")
    public ResponseEntity AddUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id, BindingResult result){

      if (result.hasErrors()){
     return ResponseEntity.badRequest().body(result.getAllErrors());
      }
      return ResponseEntity.ok(usersInterface.AddUser(userDTO,id));

    }


       @PutMapping (value ="/UpdateUser/{uid}")
    public void UpdateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Long uid){
        usersInterface.UpdateUser(userDTO,uid);
    }

    @PutMapping (value = "/DeleteUser/{id}")
    public void DeleteUser(@PathVariable Long id){usersInterface.DeleteUser(id);}
}