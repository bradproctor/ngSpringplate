package net.bradproctor.ngspringplate.dto;

import net.bradproctor.ngspringplate.domain.UserEntity;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public User() {}

    public User(UserEntity entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
