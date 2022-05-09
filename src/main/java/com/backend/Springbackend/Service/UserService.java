package com.backend.Springbackend.Service;

import java.util.List;

import com.backend.Springbackend.Entity.User;
import com.backend.Springbackend.login.Login;

public interface UserService {
  User addUser(User user);
  User getUserById(int userId);
  void updateUser(User user);
  void deleteUserById(int userId);
  List<User> getAllUsers();
  List<User> getRole(String role);
  User findByEmailAndPassword(Login login);
}