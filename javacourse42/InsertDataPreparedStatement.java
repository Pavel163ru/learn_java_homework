package javacourse42;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataPreparedStatement {
    private static final String INSERT_QUERY =
            "INSERT INTO phones (phone_number) VALUES (?)";

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_QUERY)) {

            preparedStatement.setString(1, "676767");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "445544");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "002020");
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
