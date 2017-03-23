package main.DAO.DbDaoFactory;


import main.DAO.IGoalDao;
import main.DAO.IUserDao;
import main.DAO.MySqlDao.MySqlGoalDao;
import main.DAO.MySqlDao.MySqlUserDao;

class MySqlDaoFactory extends DaoFactory {

    @Override
    public IUserDao getUserDao() {

        return new MySqlUserDao();

    }

    @Override
    public IGoalDao getGoalDao() {

        return new MySqlGoalDao();

    }

}
