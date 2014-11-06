package net.bradproctor.ngspringplate.services;

import net.bradproctor.ngspringplate.dto.User;

import java.util.List;

public interface UserService {

    public abstract List<User> getUsers();
}