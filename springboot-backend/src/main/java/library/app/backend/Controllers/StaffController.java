package library.app.backend.Controllers;

import library.app.backend.Models.Staff;
import library.app.backend.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {
    private final Services<Staff> StaffService;

    @Autowired
    StaffController(Services<Staff> StaffService) {
        this.StaffService = StaffService;
    }

    @GetMapping
    public ResponseEntity<List<Staff>> find() {
        return ResponseEntity.ok(this.StaffService.find());
    }

    @GetMapping("{id}")
    public ResponseEntity<Staff> find(@PathVariable UUID id) {
        return ResponseEntity.ok(this.StaffService.find(id));
    }

    @PostMapping()
    public ResponseEntity<Staff> create(@RequestBody Staff staff) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.StaffService.create(staff));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Staff> modify(@RequestBody Staff staff) {
        return ResponseEntity.ok(this.StaffService.modify(staff));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remove(@PathVariable UUID id) {
        this.StaffService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

