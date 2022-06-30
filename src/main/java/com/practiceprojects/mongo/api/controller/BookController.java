package com.practiceprojects.mongo.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practiceprojects.mongo.api.model.Book;
import com.practiceprojects.mongo.api.repo.IBookRepo;
@RestController
public class BookController  {
	@Autowired
	private IBookRepo bookRepo;
	@PostMapping("/addBook")
	public String saveBookDetails(@RequestBody Book b) {
		bookRepo.save(b);
		return "book added :" +b.getId() ;
	}
	@GetMapping("/getAllBooks")
	public List<Book> getBooks(){
		
		return bookRepo.findAll();
	}
	
	
	@GetMapping("/findBook/{id}")
	public Optional<Book> getBookfromId(@PathVariable int id){
		
		return bookRepo.findById(id);
	}
	
	@DeleteMapping( "/deleteBook/{id}")
	public String removeBook(@PathVariable int id){
		bookRepo.deleteById(id);
		return "Book "+ id+" deleted!";
	}
}
