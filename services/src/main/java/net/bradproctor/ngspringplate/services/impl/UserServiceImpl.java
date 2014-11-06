package net.bradproctor.ngspringplate.services.impl;

import net.bradproctor.ngspringplate.dao.UserDao;
import net.bradproctor.ngspringplate.domain.UserEntity;
import net.bradproctor.ngspringplate.dto.User;
import net.bradproctor.ngspringplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public List<User> getUsers() {
        List<UserEntity> userEntities = userDao.getUsers();
        List<User> users = new ArrayList<User>();

        for (UserEntity e : userEntities) {
            users.add(new User(e));
        }

        return users;
    }
}
