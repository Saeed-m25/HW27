package com.example.hw27.Service;

import com.example.hw27.ApiException.ApiException;
import com.example.hw27.Model.Blog;
import com.example.hw27.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    public void updateBlog(Blog blog, Integer id) {
        Blog oldBlog = blogRepository.findBlogById(id);
        if (oldBlog == null) {
            throw new ApiException("Blog not found");
            oldBlog.setId(blog.getId());
            oldBlog.setTitle(blog.getTitle());

        }


        public void deleteBlog(Integer id){
            Blog blog = blogRepository.findBlogById(id);
            if (blog == null) {
                throw new ApiException("Blog not found");
            }

            blogRepository.delete(blog);
        }

        public void addBlog(Blog blog) {
    }

    public void updateBlog(Blog blog, Integer id) {
    }
}

    public void addBlog(Blog blog) {
    }
