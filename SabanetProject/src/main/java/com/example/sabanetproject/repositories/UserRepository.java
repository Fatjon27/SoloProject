package com.example.sabanetproject.repositories;

import com.example.sabanetproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    public ArrayList<User> findAll();

    Optional<User> findByEmail(String email);
}
