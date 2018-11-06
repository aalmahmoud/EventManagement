package com.example.ServiceInterface;
import com.example.Entity.Users;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public interface UsersInterface {
    Iterable<Users> findAll();
    Optional<Users> findById(Long id);
    void DeleteUser(Long id);
     void AddUser(Users usr,Long id);
     void UpdateUser(Users uusr,Long rid);

}
