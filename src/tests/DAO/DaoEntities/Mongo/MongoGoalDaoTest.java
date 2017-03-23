package tests.DAO.DaoEntities.Mongo;

import main.DAO.DbDaoFactory.DaoFactory;
import org.junit.Test;

import java.util.UUID;


public class MongoGoalDaoTest {

    @Test
    public void find() throws Exception {
        DaoFactory mongoFactory = DaoFactory.getDefaultDaoFactory();

        UUID goalUuid = null;
        mongoFactory.getGoalDao().find(goalUuid);
    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}