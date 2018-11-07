package com.example.Repository;

import com.example.DTOs.UserDTO;
import com.example.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {


}