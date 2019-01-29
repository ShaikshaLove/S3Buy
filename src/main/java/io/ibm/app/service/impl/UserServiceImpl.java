package io.ibm.app.service.impl;

import io.ibm.app.model.User;
import io.ibm.app.repository.UserRepo;
import io.ibm.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepo repo;

    @Override
    public String saveUser(User user) {
        return repo.save(user).getUserId();
    }
}
