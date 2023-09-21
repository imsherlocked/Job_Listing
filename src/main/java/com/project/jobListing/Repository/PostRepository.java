package com.project.jobListing.Repository;

import com.project.jobListing.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>{
}

