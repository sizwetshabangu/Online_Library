package library.app.backend.Controllers;

import library.app.backend.Models.Book;
import library.app.backend.Services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> find() {
        return ResponseEntity.ok(bookService.find());
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> find(@PathVariable() UUID id) {
        return ResponseEntity.ok(bookService.find(id));
    }

    @PostMapping()
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(book));
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> modify(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remove(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
