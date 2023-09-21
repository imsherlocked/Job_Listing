package com.project.jobListing.Controller;

import com.project.jobListing.Model.Post;
import com.project.jobListing.Repository.PostRepository;
import com.project.jobListing.Repository.searchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    searchRepository searchRepo;

//    If homepage, call swagger api
    @ApiIgnore
    @RequestMapping("value=/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @PostMapping("/post")
    public Post addpost(@RequestBody Post post){
        return postRepository.save(post);
    }
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return searchRepo.findByText(text);
    }



}
