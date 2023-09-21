package com.project.jobListing.Repository;

import com.mongodb.client.*;
import com.project.jobListing.Model.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Component
public class searchRepositoryImplemenatation implements searchRepository{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("jobListing");
        MongoCollection<Document> collection = database.getCollection("jobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default").append("text",
                                new Document("query", text).append("path", Arrays.asList("techs", "desc")))),
                new Document("$sort", new Document("exp", 1L)),
                new Document("$limit", 3L)));

        result.forEach(doc -> posts.add(mongoConverter.read(Post.class, doc)));

        return posts;
    }
}
