package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookService bookService;

    @GetMapping({"/", "index", "books"})
    public String showAll(Model model) {
        List<Book> allBooks = bookService.findAll();
        model.addAttribute("books", allBooks);
        return "index";
    }
    @GetMapping("books/sortByTitle")
    public String showByTitle(Model model) {
        List<Book> sortedByTitle = bookService.sortByTitleAsc();
        model.addAttribute("books", sortedByTitle);
        return "index";
    }
    @GetMapping("books/sortByDate")
    public String showByDate(Model model) {
        List<Book> sortedByDate = bookService.sortByDateAsc();
        model.addAttribute("books", sortedByDate);
        return "index";
    }
    @GetMapping("books/sortByAuthor")
    public String showByAuthor(Model model) {
        List<Book> sortedByDate = bookService.sortByAuthorAsc();
        model.addAttribute("books", sortedByDate);
        return "index";
    }


    @GetMapping("books/{id}")
    public String showOne(@PathVariable Long id, Model model) {
        Book searchedBook = bookService.findById(id);
        model.addAttribute("book", searchedBook);
        return "book";
    }
    @GetMapping("books/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("option", "Add new book");

        return "bookform";
    }
    @GetMapping("books/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        Book bookToUpdate = bookService.findById(id);
        model.addAttribute("book", bookToUpdate);
        model.addAttribute("option", "Update book" );

        return "bookform";
    }

    @PostMapping("books")
    public String save(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bookform";
        }

        Book savedBook = bookService.save(book);
        return "redirect:/books/" + savedBook.getId();
    }

    @DeleteMapping("books/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/index";
    }

}
