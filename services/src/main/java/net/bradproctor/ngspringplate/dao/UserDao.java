package net.bradproctor.ngspringplate.dao;

import net.bradproctor.ngspringplate.domain.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends BaseDao<UserEntity>  {

    public List<UserEntity> getUsers()  {
        List<UserEntity> userEntities = findAll();

        if (userEntities.size() == 0) {
            UserEntity u = new UserEntity();
            u.setId(1L);
            u.setFirstName("John");
            u.setLastName("Smith");
            u.setEmail("jsmith@email.net");
            userEntities.add(u);

            u = new UserEntity();
            u.setId(2L);
            u.setFirstName("Jane");
            u.setLastName("Doe");
            u.setEmail("jdoe@email.net");
            userEntities.add(u);
        }

        return userEntities;
    }
}
