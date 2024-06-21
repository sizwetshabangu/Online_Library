package library.app.backend.Controllers;

import library.app.backend.Models.Book;
import library.app.backend.Models.Customer;
import library.app.backend.Services.CustomerService;
import library.app.backend.Services.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final Services<Customer> customerService;
    public CustomerController(Services<Customer> customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> find() {
        return ResponseEntity.ok(customerService.find());
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> find(@PathVariable() UUID id) {
        return ResponseEntity.ok(customerService.find(id));
    }

    @PostMapping()
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer));
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> modify(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.modify(customer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remove(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
