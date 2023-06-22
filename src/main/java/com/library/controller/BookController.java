package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String showAll(Model model) {
        List<Book> allBooks = bookService.findAll();
        model.addAttribute("books", allBooks);
        return "index";
    }
    @GetMapping("sortByTitle")
    public String showByTitle(Model model) {
        List<Book> sortedByTitle = bookService.sortByTitleAsc();
        model.addAttribute("books", sortedByTitle);
        return "index";
    }
    @GetMapping("sortByDate")
    public String showByDate(Model model) {
        List<Book> sortedByDate = bookService.sortByDateAsc();
        model.addAttribute("books", sortedByDate);
        return "index";
    }
    @GetMapping("sortByAuthor")
    public String showByAuthor(Model model) {
        List<Book> sortedByDate = bookService.sortByAuthorAsc();
        model.addAttribute("books", sortedByDate);
        return "index";
    }


    @GetMapping("{id}")
    public String showOne(@PathVariable Long id, Model model) {
        Book searchedBook = bookService.findById(id);
        model.addAttribute("book", searchedBook);
        return "book";
    }
    @GetMapping("new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());

        return "bookform";
    }
    @GetMapping("{id}/update")
    public String update(@PathVariable Long id, Model model) {
        Book bookToUpdate = bookService.findById(id);
        model.addAttribute("book", bookToUpdate);

        return "bookform";
    }

    @PostMapping
    public String save(@ModelAttribute("book") Book book, Model model) {
        Book savedBook = bookService.save(book);
        return "redirect:/books/" + savedBook.getId();
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/index";
    }

}
