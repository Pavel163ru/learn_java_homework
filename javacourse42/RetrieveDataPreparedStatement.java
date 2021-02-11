package javacourse42;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class RetrieveDataPreparedStatement {
    private static final String SELECT_QUERY =
            "SELECT * FROM phones WHERE id>? AND phone_number LIKE ?";

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASSWORD);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_QUERY)) {

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "0%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%d%23s%n", resultSet.getInt("id"), resultSet.getString("phone_number"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
