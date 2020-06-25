package controllers;

import entities.User;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.web.bind.annotation.*;
import services.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userService.getUsers();
        System.out.println("First is " + users.get(0).getUsername());
        return users;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {


        System.out.println("User " + user.getUsername());
        userService.addUser(user);
    }

}
