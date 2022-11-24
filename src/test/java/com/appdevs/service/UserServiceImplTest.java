package com.appdevs.service;

import com.appdevs.io.UsersDatabase;
import com.appdevs.io.UsersDatabaseMapImpl;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceImplTest {

    UsersDatabase usersDatabase;
    UserService userService;
    String createdUserId = "";

    @BeforeAll
    void setup() {
        usersDatabase = new UsersDatabaseMapImpl();
        usersDatabase.init();
        userService = new UserServiceImpl(usersDatabase);
    }

    @AfterAll
    void cleanup() {
        // Close connection
        //delete database

        usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works.")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Christy");
        user.put("lastName", "Choma");

        createdUserId = userService.createUser(user);

        assertNotNull(createdUserId, "User id should not be null");
    }

    @Test
    @Order(2)
    @DisplayName("Update User works.")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdateUserDetails() {
        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("firstName", "Agneau");
        newUserDetails.put("lastName", "Choma");

        Map updatedUserDetails = userService.updateUser(createdUserId, newUserDetails);

        //Assert
        assertEquals(newUserDetails.get("firstName"), updatedUserDetails.get("firstName"), "Returned value of user's first name is incorrect");
        assertEquals(newUserDetails.get("lastName"), updatedUserDetails.get("lastName"), "Returned value of user's first name is incorrect");

    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void getUserDetails() {
    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void deleteUser() {
    }
}