package com.example.demoproject.controller;

import com.example.demoproject.domain.Book;
import com.example.demoproject.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //列出书籍信息
    @GetMapping(value = "/all")
    public List<Book> bookList() {
        return bookRepository.findAll();
    }
/*
*
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "price",required = false) Double price,
            @RequestParam(value = "author",required = false) String author
            *
            * @PathVariable("id") Integer id,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "price", required = false) Double price,
                           @RequestParam(value = "author", required = false) String author
* */
    //新增书籍
    @PostMapping(value = "/add")
    public Book addBook(@RequestBody Book book) {
//        Book book = new Book();
//        book.setName(name);
//        book.setPrice(price);
//        book.setAuthor(author);
        //System.out.println(price);
        return bookRepository.save(book);
    }

    //删除书籍
    @DeleteMapping(value = "/del/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookRepository.deleteById(id);
    }

    //查询书籍信息
    @GetMapping(value = "/find/{id}")
    public Book findBook(@PathVariable("id") Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    //更新图书信息
    @PostMapping(value = "/upd")
    public Book updateBook(
            //@PathVariable("id") Integer id,
            @RequestBody Book book) {
//        Book book = new Book();
//        book.setId(id);
//        book.setName(name);
//        book.setPrice(price);
//        book.setAuthor(author);
        return bookRepository.save(book);

    }
}
