package main.DAO.DbDaoFactory;


import main.DAO.IGoalDao;
import main.DAO.IUserDao;
import main.DAO.MongoDao.*;

class MongoDaoFactory extends DaoFactory {



    @Override
    public IUserDao getUserDao() {
        return new MongoUserDao();
    }

    @Override
    public IGoalDao getGoalDao() {
        return new MongoGoalDao();
    }
}
