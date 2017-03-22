package main.DAO;

import main.DAO.ConcreteDbDaoFactory.*;
import main.DAO.DaoEntities.IGoalDao;
import main.DAO.DaoEntities.IUserDao;

public abstract class DaoFactory {

    public abstract IUserDao getUserDao();

    public abstract IGoalDao getGoalDao();


    enum DbFactory { MySql, Mongo}

    public static DaoFactory getDAOFactory(
            DbFactory dbFactory) {

        switch (dbFactory) {
            case MySql:
                return new MySqlDaoFactory();
            case Mongo:
                return new MongoDaoFactory();
            default:
                return null;
        }
    }

}
