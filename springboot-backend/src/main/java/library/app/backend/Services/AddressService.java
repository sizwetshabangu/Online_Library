package library.app.backend.Services;

import library.app.backend.Models.Address;
import library.app.backend.Repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class AddressService implements Services<Address>{
    private final AddressRepository repository;
    private final static Logger logger = Logger.getLogger(AddressService.class.getName());

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> find() {
        logger.info("Finding all addresses");
        return this.repository.findAll();
    }

    @Override
    public Address find(UUID id) throws NoSuchElementException {
        logger.info("Finding address by ID:" + id);
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public Address create(Address address) {
        logger.info("Creating new address");
        return this.repository.save(address);
    }

    @Override
    public Address modify(Address address) {
        logger.info("Modifying address");
        return this.repository.save(address);
    }

    @Override
    public void remove(UUID id) {
        logger.info("Removing address by ID:" +id);
        this.repository.deleteById(id);
    }
}
