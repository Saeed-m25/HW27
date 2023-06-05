package com.example.hw27.Service;

import com.example.hw27.ApiException.ApiException;
import com.example.hw27.Model.Blog;
import com.example.hw27.Model.User;
import com.example.hw27.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(Integer userId) {
        return userRepository.findUserByUserId(userId);
    }
    public void addUser(Integer userId,Blog blog){
        blog.setId(userId);
        userRepository.save(blog);
    }


    public void updateUser(Integer userId, User user, Integer userId) {
        User oldUser=userRepository.findUserById(userId);
        if (oldUser==null){
            throw  new ApiException("user not found");

        }
        if (oldUser.getUserId()!=userId){
            throw new ApiException("Error , unathaized");
        }
        oldUser.setMessage(user.getMessage());
        userRepository.save(oldUser);
    }

    public void deleteUser (Integer userId,Integer userId) {
        User user=userRepository.findUserById(userId);
        if (user.getUserId()!=userId){
            throw  new ApiException("Error , unathaized");

        }
        userRepository.delete(user);
    }


}

    public List<User> getUsers(Integer id) {
    }

    public void addUser(Integer id, Blog blog) {
    }

    public void updateUser(Integer id, Blog blog, Integer blogId) {
    }

    public void deleteUser(Integer id, Integer blogId) {
    }
}
