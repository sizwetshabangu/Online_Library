package library.app.backend.Services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public interface Services<T> {
    List<T> find();
    T find(UUID id) throws NoSuchElementException;
    T create(T save);
    T modify(T modify);
    void remove(UUID id);
}
