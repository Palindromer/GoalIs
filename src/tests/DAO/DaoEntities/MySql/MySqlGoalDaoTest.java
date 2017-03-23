package tests.DAO.DaoEntities.MySql;

import main.DAO.IGoalDao;
import main.DAO.DbDaoFactory.DaoFactory;
import main.Entities.Goal;
import org.junit.Test;

import java.util.List;
import java.util.UUID;


public class MySqlGoalDaoTest {
    @Test
    public void find() throws Exception {

    }

    @Test
    public void findAll() throws Exception {
        IGoalDao goalDao = DaoFactory.getDefaultDaoFactory().getGoalDao();

        List<Goal> goals = goalDao.findAll();
    }

    @Test
    public void add() throws Exception {
        DaoFactory mySqlFactory = DaoFactory.getDefaultDaoFactory();

        Goal goal = new Goal();
        goal.Id = UUID.randomUUID();
        goal.AuthorUserId = UUID.randomUUID();
        goal.Name = "Стрижка";
        goal.Description = "Підстригтися налисо.";
        mySqlFactory.getGoalDao().add(goal);
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}