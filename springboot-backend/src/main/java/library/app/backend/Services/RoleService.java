package library.app.backend.Services;

import library.app.backend.Models.Role;
import library.app.backend.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class RoleService implements Services<Role> {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> find(){
        return this.roleRepository.findAll();
    }

    public Role find(UUID id) throws NoSuchElementException {
        return this.roleRepository.findById(id).orElseThrow();
    }


    public Role create(Role role){
        return this.roleRepository.save(role);
    }

    public Role modify(Role role){
        return this.roleRepository.save(role);
    }

    public void remove(UUID id){
        this.roleRepository.deleteById(id);
    }
}
