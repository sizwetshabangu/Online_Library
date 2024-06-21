package library.app.backend.Services;

import library.app.backend.Models.Role;
import library.app.backend.Models.Staff;
import library.app.backend.Repositories.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class StaffService implements Services<Staff>{
    final private StaffRepository staffRepository;
    final private Services<Role> roleService;
    private static final Logger logger = Logger.getLogger(StaffService.class.getName());

    public StaffService(StaffRepository staffRepository, Services<Role> roleService) {
        this.staffRepository = staffRepository;
        this.roleService = roleService;
    }

    @Override
    public List<Staff> find() {
        logger.info("Finding all staff");
        return this.staffRepository.findAll();
    }

    @Override
    public Staff find(UUID id) throws NoSuchElementException {
        logger.info("Finding staff by ID: " +id);
        return this.staffRepository.findById(id).orElseThrow();
    }

    @Override
    public Staff create(Staff staff) {
        logger.info("Creating new staff");
        if(staff.getRole().getId() != null){
            Role role = roleService.find(staff.getRole().getId());
            staff.setRole(role);
        }
        return this.staffRepository.save(staff);
    }

    @Override
    public Staff modify(Staff staff) {
        logger.info("Modifying staff by ID: " +staff.getId());
        return this.staffRepository.save(staff);
    }

    @Override
    public void remove(UUID id) {
        logger.info("Removing staff by ID: " +id);
        this.staffRepository.deleteById(id);
    }
}
