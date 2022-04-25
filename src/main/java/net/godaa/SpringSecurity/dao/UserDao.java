package net.godaa.SpringSecurity.dao;

import net.godaa.SpringSecurity.models.Role;
import net.godaa.SpringSecurity.models.User;

import java.util.List;

public interface UserDao {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String role);

     User getUser(String username);

    List<User> getAllUsers();
}
