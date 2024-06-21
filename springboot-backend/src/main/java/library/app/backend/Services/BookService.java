package library.app.backend.Services;

import library.app.backend.Models.Book;
import library.app.backend.Repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class BookService implements Services<Book>{
    private final BookRepository bookRepository;
    private static final Logger logger = Logger.getLogger(BookService.class.getName());
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> find() {
        logger.info("finding all books");
        return this.bookRepository.findAll();
    }

    @Override
    public Book find(UUID id) throws NoSuchElementException {
        logger.info("finding a book with id " + id);
        return this.bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book create(Book save) {
        logger.info("creating a book " + save);
        return this.bookRepository.save(save);
    }

    @Override
    public Book modify(Book modify) {
        logger.info("modifying a book " + modify);
        return this.bookRepository.save(modify);
    }

    @Override
    public void remove(UUID id) {
        logger.info("removing a book with id " + id);
        this.bookRepository.deleteById(id);
    }
}
