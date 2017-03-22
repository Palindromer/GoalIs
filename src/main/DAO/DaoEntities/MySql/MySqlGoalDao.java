package main.DAO.DaoEntities.MySql;


import main.DAO.DaoEntities.IGoalDao;
import main.Entities.Goal;

import java.util.List;
import java.util.UUID;

public class MySqlGoalDao implements IGoalDao {

    @Override
    public Goal find(UUID id) {
        return null;
    }

    @Override
    public List<Goal> findAll() {
        return null;
    }

    @Override
    public boolean add(Goal object) {
        return false;
    }

    @Override
    public boolean update(Goal object) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}
