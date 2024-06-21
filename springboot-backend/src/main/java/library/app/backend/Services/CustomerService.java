package library.app.backend.Services;

import library.app.backend.Models.Customer;
import library.app.backend.Repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
public class CustomerService implements Services<Customer> {
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> find() {
        log.info("Find all customers");
        return this.customerRepository.findAll();
    }

    @Override
    public Customer find(UUID id) throws NoSuchElementException {
        log.info("Find customer with id {}", id);
        return this.customerRepository.findById(id).orElseThrow();
    }

    @Override
    public Customer create(Customer customer) {
        log.info("Create customer");
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer modify(Customer customer) {
        log.info("Modify customer");
        return this.customerRepository.save(customer);
    }

    @Override
    public void remove(UUID id) {
        log.info("Remove customer with id {}", id);
        this.customerRepository.deleteById(id);
    }
}
