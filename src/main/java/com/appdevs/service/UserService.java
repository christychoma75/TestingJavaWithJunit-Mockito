package com.appdevs.service;

import java.util.Map;

public interface UserService {
    String createUser(Map userDetails);

    Map updateUser(String userId, Map userDetails);

    Map getUserDetaiils(String userId);

    void deleteUser(String userId);
}
