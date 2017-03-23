package main.DAO.MySqlDao;


import main.DAO.IGoalDao;
import main.Entities.Goal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MySqlGoalDao extends AbstractMySqlDao<Goal> implements IGoalDao {

    private static final String TABLE_NAME = "goal";

    public MySqlGoalDao() {
        super(TABLE_NAME);
    }


    @Override
    public boolean add(Goal goal) {

        boolean result = false;
        try(Connection connection = getConnection()) {
            String sql = "INSERT INTO " + TABLE_NAME +
                    " (Id, AuthorUserId, Description, Name) VALUES (?,?,?,?)";

            try(PreparedStatement statement = connection.prepareStatement(sql))
            {
                statement.setString(1, goal.Id.toString());
                statement.setString(2, goal.AuthorUserId.toString());
                statement.setString(3, goal.Description);
                statement.setString(4, goal.Name);
                statement.executeUpdate();
                result = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean update(Goal object) {
        return false;
    }


    @Override
    protected Goal getObjectFromResult(ResultSet resultSet) throws SQLException {
        Goal goal = new Goal();
        goal.Id = UUID.fromString(resultSet.getString("Id"));
        goal.AuthorUserId = UUID.fromString(resultSet.getString("AuthorUserId"));
        goal.Name = resultSet.getString("Name");
        goal.Description = resultSet.getString("Description");
        return goal;
    }
}
