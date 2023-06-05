package com.example.hw27.Controller;

import com.example.hw27.Model.Blog;
import com.example.hw27.Model.User;
import com.example.hw27.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("get")
    public ResponseEntity getUsers (@AuthenticationPrincipal User user) {
        List<User> userList = userService.getUsers(user.getId());
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser (@AuthenticationPrincipal User user , @RequestBody Blog blog) {
        userService.addUser(user.getId(), blog);
        return ResponseEntity.status(200).body("user adeed");

    }

    @PutMapping("/update/{blogId}")
    public ResponseEntity updateUser (@AuthenticationPrincipal User user ,@RequestBody Blog blog, @PathVariable Integer blogId) {
        userService.updateUser(user.getId(),blog,blogId);
        return ResponseEntity.status(200).body("blog update");
    }


    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity deleteUser(@AuthenticationPrincipal User user, @PathVariable Integer blogId ) {
        userService.deleteUser(user.getId(),blogId);
        return ResponseEntity.status(200).body("blog deleted");


    }
}
