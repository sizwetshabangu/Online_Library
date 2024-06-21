package library.app.backend.Controllers;

import library.app.backend.Models.Role;
import library.app.backend.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {
    private final Services<Role> roleService;

    @Autowired
    public RoleController(Services<Role> roleService) {
        this.roleService = roleService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> find(@PathVariable UUID id) {
        return ResponseEntity.ok(this.roleService.find(id));
    }

    @GetMapping()
    public ResponseEntity<List<Role>> find() {
        return ResponseEntity.ok(this.roleService.find());
    }

    @PostMapping()
    public ResponseEntity<Role> create(@RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roleService.create(role));
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> modify(@PathVariable UUID id, @RequestBody Role role) {
        return ResponseEntity.ok(this.roleService.modify(role));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.roleService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
