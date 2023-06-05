package com.example.hw27.Controller;


import com.example.hw27.Model.Blog;
import com.example.hw27.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {


    private final BlogService blogService;


    @GetMapping("/get")
    public ResponseEntity getAllBlog(){
        List<Blog> blogList=blogService.getAllBlog();
        return ResponseEntity.status(200).body(blogList);
    }


    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog){
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body(new ApiResponse("Blog added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog, @PathVariable Integer id){
        blogService.updateBlog(blog,id);
        return ResponseEntity.status(200).body("Blog Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("Blog deleted");



    }
}

}
