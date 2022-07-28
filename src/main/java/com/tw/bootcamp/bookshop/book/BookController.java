package com.tw.bootcamp.bookshop.book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    @Operation(summary = "List all books", description = "Lists all books in bookshop", tags = {"Books Service"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List all books",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookResponse.class))})
    })
    List<BookResponse> list() {
        List<Book> books = bookService.fetchAll();
        return books.stream()
                .map(book -> book.toResponse())
                .collect(Collectors.toList());
    }


    @GetMapping("/books/{authorName}")
    List<BookResponse> listBooksByAuthorName(@PathVariable(name = "authorName") String authorName){
        List<Book> books = bookService.fetchByAuthorName(authorName);
        return books.stream()
                .map(book -> book.toResponse())
                .collect(Collectors.toList());
    }
    @PostMapping(value = "/books")
    ResponseEntity<BookResponse> addBook(@RequestBody CreateBookRequest bookRequest) {
        Book book = bookService.create(bookRequest);
        return new ResponseEntity<>(book.toResponse(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/books/{id}")
    ResponseEntity<BookResponse> updateBook(@PathVariable("id") Long id, @RequestBody CreateBookRequest bookRequest){
        Book book = bookService.update(id, bookRequest);
        return new ResponseEntity<>(book.toResponse(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/books/{id}")
    void delete(@PathVariable("id") Long id){
        if( bookService.findById(id)){
            bookService.delete(id);
        }
    }

}
