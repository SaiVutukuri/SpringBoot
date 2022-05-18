package com.backend.Springbackend.ServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.backend.Springbackend.Entity.User;
import com.backend.Springbackend.Repository.UserRepository;
import com.backend.Springbackend.Service.UserService;
import com.backend.Springbackend.login.Login;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private UserRepository repository;
  @Override
  public User addUser(User user) {
    return repository.save(user);
  }
  @Override
  public User getUserById(int userId) {
    return repository.findById(userId).get();
  }
  @Override
  public List<User> getAllUsers(){
    return repository.findAll();
  }
  @Override
  public void updateUser(User user) {
    // check if the user with the passed id exists or not
//    User userDB = repository.findById(user.getUserId()).orElseThrow();
    Optional<User> userDB = repository.findById(user.getUserId());
    // If user exists then updated
    repository.save(user);
  }
  
  @Override
  public void deleteUserById(int userId) {
    try {
      repository.deleteById(userId);  
    }catch(DataAccessException ex){
      throw new RuntimeException(ex.getMessage());
    }
  }
@Override
public List<User> getRole(String role) {
	List<User> roles = new ArrayList<User>();
	roles=repository.findByRole(role);
	return roles;
}
@Override
public User findByEmailAndPassword(Login login) {
	User profile = new User();
	  profile = repository.findByEmailAndPassword(login.getEmail(), login.getPassword());
	return profile;
}
}