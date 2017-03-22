package main.DAO.ConcreteDbDaoFactory;


import main.DAO.DaoEntities.MySql.*;
import main.DAO.DaoFactory;
import main.DAO.DaoEntities.IGoalDao;
import main.DAO.DaoEntities.IUserDao;

public class MySqlDaoFactory extends DaoFactory {
    @Override
    public IUserDao getUserDao() {
        return new MySqlUserDao();
    }

    @Override
    public IGoalDao getGoalDao() {
        return new MySqlGoalDao();
    }
}
