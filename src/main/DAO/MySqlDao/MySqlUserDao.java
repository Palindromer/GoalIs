package main.DAO.MySqlDao;


import main.DAO.IUserDao;
import main.Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MySqlUserDao extends AbstractMySqlDao<User> implements IUserDao {

    private static final String TABLE_NAME = "user";


    @Override
    public boolean add(final User user){

        boolean result = false;
        try(Connection connection = getConnection()) {
            String sql = "INSERT INTO " + TABLE_NAME +
                    " (Id, AuthorUserId, Description, Name) VALUES (?,?,?,?)";

            try(PreparedStatement statement = connection.prepareStatement(sql))
            {
                statement.setString(1, user.Id.toString());
                statement.setString(2, user.FirstName);
                statement.setString(3, user.SecondName);
                statement.setInt(4, user.Age);
                statement.setString(5, user.HashPassword);
                statement.setString(6, user.Salt);
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

    @Override    public boolean update(final User user) {
        boolean result = false;
        try (Connection connection = getConnection())
        {
            String sql = "UPDATE " + getTableName() +
                    " SET FirstName = ?, SecondName = ?, Age = ?, HashPassword = ?, Salt = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql))
            {
                statement.setString(1, user.FirstName);
                statement.setString(2, user.SecondName);
                statement.setInt(3,     user.Age);
                statement.setString(4, user.HashPassword);
                statement.setString(5, user.Salt);
                statement.setString(6, user.Id.toString());
                statement.executeUpdate();
                result = true;
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    protected User getObjectFromResult(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.Id = UUID.fromString(resultSet.getString("Id"));
        user.FirstName = resultSet.getString("FirstName");
        user.SecondName= resultSet.getString("SecondName");
        user.Age = resultSet.getInt("Age");
        user.HashPassword= resultSet.getString("HashPassword");
        user.Salt= resultSet.getString("Salt");

        return user;
    }

    protected String getTableName() {
        return TABLE_NAME;
    }
}
