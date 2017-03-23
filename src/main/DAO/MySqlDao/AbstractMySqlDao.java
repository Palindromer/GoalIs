package main.DAO.MySqlDao;

import main.DAO.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractMySqlDao<T> implements IDao<T> {

    private static final String DATABASE_URL =
            "jdbc:mysql://localhost:3306/goalin?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DATABASE_USER = "rooter";
    private static final String DATABASE_USER_PASSWORD = "rooter";


    protected String TABLE_NAME;

    protected AbstractMySqlDao() {

    }

    protected Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_USER_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }


    @Override
    public T find(final UUID id) {
        T object = null;

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";

            try (PreparedStatement statement =
                         connection.prepareStatement(sql)) {
                statement.setString(1, id.toString());
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    object = getObjectFromResult(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }


    @Override
    public List<T> findAll() {
        List<T> objects = new ArrayList<>();

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM " + getTableName();

            try (PreparedStatement statement
                         = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    objects.add(getObjectFromResult(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objects;
    }


    @Override
    public boolean delete(final UUID id) {
        boolean result = false;
        try (Connection connection = getConnection()) {

            String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";

            try (PreparedStatement statement =
                         connection.prepareStatement(sql)) {
                statement.setString(1, id.toString());
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


    protected abstract T getObjectFromResult(ResultSet resultSet)
            throws SQLException;

    protected abstract String getTableName();
}
