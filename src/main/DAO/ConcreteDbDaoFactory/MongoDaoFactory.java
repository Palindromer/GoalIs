package main.DAO.ConcreteDbDaoFactory;


import main.DAO.DaoEntities.IGoalDao;
import main.DAO.DaoEntities.IUserDao;
import main.DAO.DaoEntities.Mongo.*;
import main.DAO.DaoFactory;

public class MongoDaoFactory extends DaoFactory {
    @Override
    public IUserDao getUserDao() {
        return new MongoUserDao();
    }

    @Override
    public IGoalDao getGoalDao() {
        return new MongoGoalDao();
    }
}
