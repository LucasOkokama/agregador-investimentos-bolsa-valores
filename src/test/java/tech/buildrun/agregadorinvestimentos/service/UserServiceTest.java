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
import tech.buildrun.agregadorinvestimentos.controller.CreateUserDTO;
import tech.buildrun.agregadorinvestimentos.entity.User;
import tech.buildrun.agregadorinvestimentos.repository.UserRepository;

import java.time.Instant;
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

      doReturn(user).when(userRepository).save(any(User.class));

      var output = userService.createUser(input);
      assertNotNull(output);

      verify(userRepository).save(userArgumentCaptor.capture());

      var userCaptured = userArgumentCaptor.getValue();
      assertEquals(input.username(), userCaptured.getUsername());
      assertEquals(input.email(), userCaptured.getEmail());
      assertEquals(input.password(), userCaptured.getPassword());
    }

    @Test
    @DisplayName("Should throw exception when error occurs")
    void shouldThrowExceptionWhenErrorOccurs(){
      doThrow(new RuntimeException()).when(userRepository).save(any());

      var input = new CreateUserDTO(
              "username",
              "email@gmail.com",
              "password"
      );

      assertThrows(RuntimeException.class, () -> userService.createUser(input));
    }

  }
}