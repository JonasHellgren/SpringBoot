package org.example.jsonl_ist_from_postman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * web
 * http://localhost:8080/books/addall
 * http://localhost:8080/books/getall
 */

@RestController
@RequestMapping(path = "/books")
public class Controller {

    List<OneBook> bookList;

    @PostConstruct
    public void init() {
        bookList = new ArrayList<>();
        OneBook book=new OneBook("Shantaram",11);
        bookList.add(book);
    }

    @GetMapping(value = "/getall")
    public List<OneBook> getAll() {
        return bookList;
    }

    @PostMapping(value = "/addall")
    //@RequestBody needed to work with json
    public List<OneBook> addBooks(@RequestBody Books books) {
        bookList.addAll(books.getBooks());
        System.out.println("books = " + books);
        System.out.println("books.getTotalPrice() = " + books.getTotalPrice());
        return bookList;
    }
}
