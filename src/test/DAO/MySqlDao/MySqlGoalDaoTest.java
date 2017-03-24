package tests.DAO.MySqlDao;

import main.DAO.DbDaoFactory.DaoFactory;
import main.DAO.IGoalDao;
import main.Entities.Goal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.UUID;


public class MySqlGoalDaoTest {
    @Test
    public void find() throws Exception {
        IGoalDao goalDao = DaoFactory.getDefaultDaoFactory().getGoalDao();

        Goal goal = goalDao.find(UUID.fromString("8d11edec-4555-4290-ab2e-3a119208c8cc"));

        Assert.assertEquals(goal.Name, "Жонглювання");
    }

    @Test
    public void findAll() throws Exception {
        IGoalDao goalDao = DaoFactory.getDefaultDaoFactory().getGoalDao();

        List<Goal> goals = goalDao.findAll();
        Assert.assertEquals(goals.size(), 2);
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