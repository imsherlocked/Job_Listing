package com.project.jobListing.Repository;

import com.project.jobListing.Model.Post;

import java.util.List;

public interface searchRepository {
    List<Post> findByText(String text);
}
