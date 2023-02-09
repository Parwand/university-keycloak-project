package net.parwand.studentapp.infrastructure.db;

import net.parwand.studentapp.applicationservice.repository.UserRepository;
import net.parwand.studentapp.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }
}
