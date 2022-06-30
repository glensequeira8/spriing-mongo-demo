package com.practiceprojects.mongo.api.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practiceprojects.mongo.api.model.Book;

public interface IBookRepo extends MongoRepository<Book, Integer>{

	

}
