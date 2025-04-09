package tech.buildrun.agregadorinvestimentos.service;

import org.springframework.stereotype.Service;
import tech.buildrun.agregadorinvestimentos.controller.CreateUserDTO;
import tech.buildrun.agregadorinvestimentos.entity.User;
import tech.buildrun.agregadorinvestimentos.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UUID createUser(CreateUserDTO createUserDTO){
    var entity = new User(
            null,
            createUserDTO.username(),
            createUserDTO.email(),
            createUserDTO.password(),
            Instant.now(),
            null
    );

    var userSaved = userRepository.save(entity);
    return userSaved.getUserId();
  }

  public Optional<User> getUserById(String userId){
    return userRepository.findById(UUID.fromString(userId));
  }

  public List<User> listUsers(){
    return userRepository.findAll();
  }

  public void deleteById(String userId){
    var id = UUID.fromString(userId);

    var userExists = userRepository.existsById(id);

    if(userExists){
      userRepository.deleteById(id);
    }
  }
}
