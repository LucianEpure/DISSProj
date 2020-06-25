package services;

import entities.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    User findUser(String username);

    List<User> getUsers();

    void addUser(User user);

//    void addAttendance(User user);
}
