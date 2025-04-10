package tech.buildrun.agregadorinvestimentos.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.buildrun.agregadorinvestimentos.controller.dto.CreateUserDTO;
import tech.buildrun.agregadorinvestimentos.controller.dto.UpdateUserDTO;
import tech.buildrun.agregadorinvestimentos.entity.User;
import tech.buildrun.agregadorinvestimentos.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @Captor
  private ArgumentCaptor<User> userArgumentCaptor;

  @Captor
  private ArgumentCaptor<UUID> uuidArgumentCaptor;

  @Nested
  class createUser{

    @Test
    @DisplayName("Should create a user with success")
    void shouldCreateAUserWithSuccess(){

      var user = new User(
              UUID.randomUUID(),
              "username",
              "email@gmail.com",
              "password",
              Instant.now(),
              null
      );

      var input = new CreateUserDTO(
              "username",
              "email@gmail.com",
              "password"
      );

      doReturn(user)
              .when(userRepository)
              .save(userArgumentCaptor.capture());

      var output = userService.createUser(input);
      assertNotNull(output);

      var userCaptured = userArgumentCaptor.getValue();
      assertEquals(input.username(), userCaptured.getUsername());
      assertEquals(input.email(), userCaptured.getEmail());
      assertEquals(input.password(), userCaptured.getPassword());
    }

    @Test
    @DisplayName("Should throw exception when error occurs")
    void shouldThrowExceptionWhenErrorOccurs(){
      doThrow(new RuntimeException())
              .when(userRepository)
              .save(any());

      var input = new CreateUserDTO(
              "username",
              "email@gmail.com",
              "password"
      );

      assertThrows(RuntimeException.class, () -> userService.createUser(input));
    }

  }

  @Nested
  class getUserById{
    @Test
    @DisplayName("Should get user by id with success when optional is present")
    void shouldGetUserByIdWithSuccessWhenOptionalIsPresent(){
      var user = new User(
              UUID.randomUUID(),
              "username",
              "email@gmail.com",
              "password",
              Instant.now(),
              null
      );

      doReturn(Optional.of(user))
              .when(userRepository)
              .findById(uuidArgumentCaptor.capture());

      var output = userService.getUserById(user.getUserId().toString());

      assertTrue(output.isPresent());
      assertEquals(user.getUserId(), uuidArgumentCaptor.getValue());
    }

    @Test
    @DisplayName("Should get user by id with success when optional is empty")
    void shouldGetUserByIdWithSuccessWhenOptionalIsEmpty(){
      var userId = UUID.randomUUID();

      doReturn(Optional.empty())
              .when(userRepository)
              .findById(uuidArgumentCaptor.capture());

      var output = userService.getUserById(userId.toString());

      assertTrue(output.isEmpty());
      assertEquals(userId, uuidArgumentCaptor.getValue());
    }
  }

  @Nested
  class listUsers{
    @Test
    @DisplayName("Should return all users with success")
    void shouldReturnAllUsersWithSuccess(){
      var user = new User(
              UUID.randomUUID(),
              "username",
              "email@gmail.com",
              "password",
              Instant.now(),
              null
      );

      var userList = List.of(user);

      doReturn(userList)
              .when(userRepository)
              .findAll();

      var output = userService.listUsers();

      assertNotNull(output);
      assertEquals(userList.size(), output.size());
    }
  }

  @Nested
  class deleteById{
    @Test
    @DisplayName("Should delete user with success when user exists")
    void shouldDeleteUserWithSuccessWhenUserExists(){
      doReturn(true)
              .when(userRepository)
              .existsById(uuidArgumentCaptor.capture());

      doNothing()
              .when(userRepository)
              .deleteById(uuidArgumentCaptor.capture());

      var userId = UUID.randomUUID();
      userService.deleteById(userId.toString());

      var idList = uuidArgumentCaptor.getAllValues();
      assertEquals(userId, idList.get(0));
      assertEquals(userId, idList.get(1));

      verify(userRepository, times(1)).existsById(idList.get(0));
      verify(userRepository, times(1)).deleteById(idList.get(1));
    }

    @Test
    @DisplayName("Should delete user with success when user NOT exists")
    void shouldDeleteUserWithSuccessWhenUserNotExists(){
      doReturn(false)
              .when(userRepository)
              .existsById(uuidArgumentCaptor.capture());

      var userId = UUID.randomUUID();
      userService.deleteById(userId.toString());

      assertEquals(userId, uuidArgumentCaptor.getValue());

      verify(userRepository, times(1)).existsById(uuidArgumentCaptor.getValue());
      verify(userRepository, times(0)).deleteById(any());
    }
  }

  @Nested
  class updateUserById{
    @Test
    @DisplayName("Should update user by id when user exists and username and password are filled")
    void shouldUpdateUserByIdWhenUserExistsAndUsernameAndPasswordAreFilled(){

      var user = new User(
              UUID.randomUUID(),
              "username",
              "email@gmail.com",
              "password",
              Instant.now(),
              null
      );

      var updateUserDTO = new UpdateUserDTO(
              "newUsername",
              "newPassword"
      );

      doReturn(Optional.of(user))
              .when(userRepository)
              .findById(uuidArgumentCaptor.capture());

      doReturn(user)
              .when(userRepository)
              .save(userArgumentCaptor.capture());

      userService.updateUserById(user.getUserId().toString(), updateUserDTO);

      assertEquals(user.getUserId(), uuidArgumentCaptor.getValue());

      var userCapture = userArgumentCaptor.getValue();
      assertEquals(updateUserDTO.username(), userCapture.getUsername());
      assertEquals(updateUserDTO.password(), userCapture.getPassword());

      verify(userRepository, times(1))
              .findById(uuidArgumentCaptor.getValue());
      verify(userRepository, times(1))
              .save(user);
    }

    @Test
    @DisplayName("Should not update user by id when user not exists")
    void shouldNotUpdateUserByIdWhenUserNotExists(){

      var userId = UUID.randomUUID();
      var updateUserDTO = new UpdateUserDTO(
              "newUsername",
              "newPassword"
      );

      doReturn(Optional.empty())
              .when(userRepository)
              .findById(uuidArgumentCaptor.capture());

      userService.updateUserById(userId.toString(), updateUserDTO);

      assertEquals(userId, uuidArgumentCaptor.getValue());

      verify(userRepository, times(1))
              .findById(uuidArgumentCaptor.getValue());
      verify(userRepository, times(0))
              .save(any());
    }
  }
}