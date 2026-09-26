package com.khun.homework1.Controller;
import com.khun.homework1.Model.BookModel;
import com.khun.homework1.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping
    public List<BookModel> findAll(){
        return bookService.getAllBook();
    }
    @GetMapping("/{Id}")
    public ResponseEntity<?> findbyid(@PathVariable int Id){
        BookModel book = bookService.getBookById(Id);
        if(book==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message","Not Found"));
        }
        return ResponseEntity.ok(book);
    }
    @PostMapping
    public BookModel save(@RequestBody BookModel bookModel){
        return bookService.createBook(bookModel);
    }
    @PutMapping("/{Id}")
    public BookModel update(@PathVariable int Id,@RequestBody BookModel bookModel){
        return bookService.updateBook(Id,bookModel);

    }
    @DeleteMapping("/{Id}")
    public BookModel delete(@PathVariable int Id){
        return bookService.deleteBook(Id);
    }
}
