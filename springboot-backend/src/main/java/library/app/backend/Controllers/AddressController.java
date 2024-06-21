package library.app.backend.Controllers;

import library.app.backend.Models.Address;
import library.app.backend.Services.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/address")
public class AddressController {
    private final Services<Address> addressService;
    AddressController(Services<Address> addressService) {
        this.addressService = addressService;
    }

    @GetMapping()
    public ResponseEntity<List<Address>> find() {
        return ResponseEntity.ok(this.addressService.find());
    }

    @GetMapping("{id}")
    public ResponseEntity<Address> find(@PathVariable() UUID id) {
        return ResponseEntity.ok(addressService.find(id));
    }

    @PostMapping()
    public ResponseEntity<Address> create(@RequestBody Address address) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.create(address));
    }

    @PutMapping("{id}")
    public ResponseEntity<Address> modify(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.modify(address));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remove(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
