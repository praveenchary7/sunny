package com.springbootwithhibexample;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

	@Autowired
	public BookRepo bookrepo;
	
	@PostMapping("savebook")
	public ResponseEntity<Book>  savebook(@RequestBody Book book)
	{
		System.out.println(book);
		bookrepo.save(book);
		ResponseEntity<Book> re = new ResponseEntity<>(book,HttpStatus.CREATED);
		return re;
		
	}
	
	@GetMapping("getbookbyid/{id}")
	public ResponseEntity<Book> getbookbyid(@PathVariable Integer id)
	{
		System.out.println("ID:"+id);
		ResponseEntity<Book> re;
		Optional<Book> opt = bookrepo.findById(id);
		if(opt.isPresent())
		{
			System.out.println("book:"+opt.get());
			re = new ResponseEntity<Book>(opt.get(),HttpStatus.OK);
			return re;
		}
		else
		{
			System.out.println("No Book Found");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		
	}
}
