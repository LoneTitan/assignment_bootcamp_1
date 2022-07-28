package com.tw.bootcamp.bookshop.book;

import com.tw.bootcamp.bookshop.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> fetchAll() {
        return bookRepository.findAllByOrderByNameAsc();
    }
    public List<Book> fetchByAuthorName(String authorName){
        return bookRepository.findAllByAuthorName(authorName);
    }

    public Book create(CreateBookRequest bookRequest) {
        Book book = new Book(bookRequest.getName(), bookRequest.getAuthorName(), bookRequest.getImageUrl() ,bookRequest.getPrice());
        return bookRepository.save(book);
    }

    public Book update(Long bookId,CreateBookRequest bookRequest) {
        Book book = bookRepository.findById(bookId).get();
        Book.update(book,bookRequest);
        return bookRepository.save(book);
    }


    public void delete(Long id) {
        bookRepository.deleteById(id);

    }

    public boolean findById(Long id) {
        return null != bookRepository.findById(id).orElse(null);
    }
}
