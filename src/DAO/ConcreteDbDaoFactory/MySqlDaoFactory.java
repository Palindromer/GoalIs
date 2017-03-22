package DAO.ConcreteDbDaoFactory;


import DAO.DaoEntities.MySql.*;
import DAO.DaoFactory;
import DAO.DaoEntities.IGoalDao;
import DAO.DaoEntities.IUserDao;

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
