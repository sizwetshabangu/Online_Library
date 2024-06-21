package library.app.backend.Services;

import library.app.backend.Models.Role;
import library.app.backend.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class RoleService implements Services<Role> {
    private final RoleRepository roleRepository;
    private static final Logger logger = Logger.getLogger(RoleService.class.getName());
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> find(){
        logger.info("finding all roles");
        return this.roleRepository.findAll();
    }

    @Override
    public Role find(UUID id) throws NoSuchElementException {
        logger.info("finding role with id " + id);
        return this.roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Role create(Role role){
        logger.info("creating role " + role);
        return this.roleRepository.save(role);
    }

    @Override
    public Role modify(Role role){
        logger.info("modifying role " + role);
        return this.roleRepository.save(role);
    }

    @Override
    public void remove(UUID id){
        logger.info("removing role with id " + id);
        this.roleRepository.deleteById(id);
    }
}
