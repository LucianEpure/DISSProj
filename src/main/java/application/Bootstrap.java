package application;

import entities.Role;
import entities.TimeSheet;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.RoleRepository;
import services.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap {
    private RoleRepository roleRepository;
    private UserService userService;
    @Autowired
    public Bootstrap(UserService userService, RoleRepository roleRepository){
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @PostConstruct
    private void initialize(){
        initRoles();
        initUsers();
    }

    private void initRoles() {
        Role admin = new Role("ADMIN");
        Role humanResources = new Role("HR");
        roleRepository.save(admin);
        roleRepository.save(humanResources);
    }

    private void initUsers() {
        User user1 = new User();
        user1.setUsername("Admin1");
        user1.setPassword("1234");
        List<Role> user1Roles = new ArrayList<Role>();
        Role user1Role = roleRepository.findByRoleName("ADMIN");
        user1Roles.add(user1Role);
        user1.setRoles(user1Roles);
        userService.registerUser(user1);

        User user2 = new User();
        user2.setUsername("Gigel");
        user2.setPassword("1234");
        List<Role> user2Roles = new ArrayList<Role>();
        Role user2Role = roleRepository.findByRoleName("HR");
        user2Roles.add(user2Role);
        user2.setRoles(user2Roles);
        userService.registerUser(user2);
    }

    private void addTimesheet() {
        TimeSheet timeSheet = new TimeSheet();
        //timeSheet;
    }
}
