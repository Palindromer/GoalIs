package main.DAO.MongoDao;


import main.DAO.IUserDao;
import main.Entities.User;

import java.util.List;
import java.util.UUID;


public class MongoUserDao extends AbstractMongoDao<User>  implements IUserDao {

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
