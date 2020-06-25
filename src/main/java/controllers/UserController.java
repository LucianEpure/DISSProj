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
        return (List<User>) userService.getUsers();
    }
    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

}
