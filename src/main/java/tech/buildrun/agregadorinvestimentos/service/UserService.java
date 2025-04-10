package tech.buildrun.agregadorinvestimentos.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.buildrun.agregadorinvestimentos.controller.dto.CreateAccountDto;
import tech.buildrun.agregadorinvestimentos.controller.dto.CreateUserDTO;
import tech.buildrun.agregadorinvestimentos.controller.dto.UpdateUserDTO;
import tech.buildrun.agregadorinvestimentos.entity.Account;
import tech.buildrun.agregadorinvestimentos.entity.BillingAddress;
import tech.buildrun.agregadorinvestimentos.entity.User;
import tech.buildrun.agregadorinvestimentos.repository.AccountRepository;
import tech.buildrun.agregadorinvestimentos.repository.BillingAddressRepository;
import tech.buildrun.agregadorinvestimentos.repository.UserRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

  private UserRepository userRepository;
  private AccountRepository accountRepository;
  private BillingAddressRepository billingAddressRepository;

  public UserService(UserRepository userRepository, AccountRepository accountRepository, BillingAddressRepository billingAddressRepository) {
    this.userRepository = userRepository;
    this.accountRepository = accountRepository;
    this.billingAddressRepository = billingAddressRepository;
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

  public void updateUserById(String userId, UpdateUserDTO updateUserDTO){
    var id = UUID.fromString(userId);
    var userEntity = userRepository.findById(id);

    if(userEntity.isPresent()){
      var user = userEntity.get();

      if(updateUserDTO.username() != null){
        user.setUsername(updateUserDTO.username());
      }

      if(updateUserDTO.password() != null){
        user.setPassword(updateUserDTO.password());
      }

      userRepository.save(user);
    }
  }

  public void deleteById(String userId){
    var id = UUID.fromString(userId);
    var userExists = userRepository.existsById(id);

    if(userExists){
      userRepository.deleteById(id);
    }
  }

  public void createAccount(String userId, CreateAccountDto createAccountDto) {
    var user = userRepository.findById(UUID.fromString(userId))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    var account = new Account(
            null,
            user,
            null, // ainda sem billingAddress
            createAccountDto.description(),
            new ArrayList<>()
    );

    var accountCreated = accountRepository.save(account);

    var billingAddress = new BillingAddress(
            null,
            accountCreated,
            createAccountDto.street(),
            createAccountDto.number()
    );

    billingAddressRepository.save(billingAddress);
  }

}
