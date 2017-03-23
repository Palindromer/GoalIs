package main.DAO.DbDaoFactory;

import main.DAO.IGoalDao;
import main.DAO.IUserDao;

public abstract class DaoFactory {

    public abstract IUserDao getUserDao();

    public abstract IGoalDao getGoalDao();



    public static DaoFactory getDefaultDaoFactory()
    {
        return getDAOFactory(DbFactory.MySql);
    }

    private enum DbFactory { MySql, Mongo}

    private static DaoFactory getDAOFactory(
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
