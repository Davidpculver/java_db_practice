package dao;

import models.User;

import java.util.List;

public interface Users {
    User findByUserEmail(String email);
    User findByUsername(String username);
    Long insert(User user);
    User updateUser(String email, String userName);
}
