package com.demoApplication.Book_Management.controller;

import  com.demoApplication.Book_Management.model.Book;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private List<Book> books = new ArrayList<>();

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @GetMapping
    public List<Book> book() {
        return books;
    }

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable int id){
        return books.get(id);
    }

    @GetMapping("/title/{title}")
    public Book getBookByTitle(@PathVariable String title){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }

    @GetMapping("/author/{author}")
    public Book getBookByAuthor(@PathVariable String author){
        for(Book book : books){
            if(book.getAuthor().equalsIgnoreCase(author)){
                return book;
            }
        }
        return null;
    }

    @GetMapping("/price/{price}")
    public Book getBookByPrice(@PathVariable int price){
        for(Book book : books){
            if(book.getPrice() == price){
                return book;
            }
        }
        return null;
    }

    @PutMapping("/id/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updateBook) {
            for(Book book : books){
                if(book.getId() == id){
                    book.setTitle(updateBook.getTitle());
                    book.setAuthor(updateBook.getAuthor());
                    book.setCategory(updateBook.getCategory());
                    book.setPrice(updateBook.getPrice());
                    return book;
                }
            }
            return null;
    }

    @DeleteMapping("/id/{id}")
    public Book deleteBook(@PathVariable int id){
        return books.remove(id);
    }

}
