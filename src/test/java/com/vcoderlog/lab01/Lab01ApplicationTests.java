package com.vcoderlog.lab01;

import com.vcoderlog.lab01.reponsitory.UserRepository;
import com.vcoderlog.lab01.reponsitory.models.User;
import com.vcoderlog.lab01.reponsitory.models.request.user.CreateUserRequest;
import com.vcoderlog.lab01.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class Lab01ApplicationTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void createUser_ValidUser_ReturnsTrue() throws Exception {
        // Arrange
        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("testUser");
        request.setPassword("testPassword");

        when(userRepository.save(any())).thenReturn(new User("testUser", "hashedPassword"));


        boolean result = userService.createUser(request);


        assertTrue(result);
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void createUser_InvalidUser_ThrowsException() {

        CreateUserRequest request = new CreateUserRequest();


        Exception exception = assertThrows(Exception.class, () -> userService.createUser(request));
        assertEquals("Invalid User Request", exception.getMessage());
        verify(userRepository, never()).save(any());
    }
    @Test
    void loadUserByUsername_UserExists_ReturnsUserDetails() {
        // Arrange
        String username = "testUser";
        User user = new User(username, "hashedPassword");
        when(userRepository.findByUsername(username)).thenReturn(user);

        // Act
        UserDetails userDetails = userService.loadUserByUsername(username);

        // Assert
        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        verify(userRepository, times(1)).findByUsername(username);
    }
}
