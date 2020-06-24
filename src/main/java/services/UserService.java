package services;

import entities.User;

public interface UserService {

    void registerUser(User user);

    User findUser(String username);

    void addAttendance(User user);
}
