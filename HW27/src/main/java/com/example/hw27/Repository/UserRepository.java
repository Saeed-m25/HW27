package com.example.hw27.Repository;

import com.example.hw27.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findUserByUserId(Integer id);

    User findUserById(Integer userId);
}
