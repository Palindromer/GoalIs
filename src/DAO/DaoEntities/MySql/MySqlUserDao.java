package DAO.DaoEntities.MySql;


import DAO.DaoEntities.IUserDao;
import Entities.User;

import java.util.List;
import java.util.UUID;

public class MySqlUserDao  implements IUserDao {
    @Override
    public User find(UUID id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean add(User object) {
        return false;
    }

    @Override
    public boolean update(User object) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}
