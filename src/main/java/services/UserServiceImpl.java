package services;

import entities.Role;
import entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import repositories.RoleRepository;
import repositories.UserRepository;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        //BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        User dbUser = new User();
        dbUser.setUsername(user.getUsername());
       // dbUser.setPassword(enc.encode(user.getPassword()));
        dbUser.setPassword(user.getPassword());

        System.out.println(user.getRoles().get(0).getRoleName());
        List<Role> dbUserRoles = user.getRoles();
        dbUser.setRoles(dbUserRoles);

        userRepository.save(dbUser);
    }
}
