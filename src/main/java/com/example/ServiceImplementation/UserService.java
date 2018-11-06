package com.example.ServiceImplementation;

import com.example.Entity.Roles;
import com.example.Entity.Users;
import com.example.Repository.RolesRepository;
import com.example.Repository.UserRepository;
import com.example.ServiceInterface.UsersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService implements UsersInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private NotificationService notificationService;

    @Override
    public void AddUser(Users usr,Long id) {
        usr.setRolesid(rolesRepository.findById(id).get());
        userRepository.save(usr);
        notificationService.sendNotificaitoin(usr.getUseremail(),"Event Management CO.",  "Welcome to our website \uD83D\uDE0A : "+ usr.getUsername());
    }

    @Override
    public void UpdateUser(Users uusr,Long rid) {
        /*  need coding here*/
        uusr.setRolesid(rolesRepository.findById(rid).get());
        uusr.getUserid();

        userRepository.save(uusr);
    }

    public Iterable<Users> findAll() {
    return userRepository.findAll();
    }
    public Optional<Users> findById(Long id) {
    return userRepository.findById(id);
    }

    @Override
    public void DeleteUser(Long id) {
    Users duser = userRepository.findById(id).get();
    duser.setDeleted(true);
    userRepository.save(duser);

    }



}
