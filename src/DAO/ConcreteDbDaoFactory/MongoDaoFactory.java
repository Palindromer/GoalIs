package DAO.ConcreteDbDaoFactory;


import DAO.DaoEntities.IGoalDao;
import DAO.DaoEntities.IUserDao;
import DAO.DaoEntities.Mongo.*;
import DAO.DaoFactory;

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
