package services;

import entities.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    User findUser(String username);

    List<User> getUsers();

    void addUser(User user);

    void removeUser(User user);

    void removeUserById(int id);

//    void addAttendance(User user);
}
