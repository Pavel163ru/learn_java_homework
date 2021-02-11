package javacourse42;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreatingTable {
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE phones "
                    + "(id INT(5) NOT NULL AUTO_INCREMENT,"
                    + " user_id INT(5),"
                    + " phone_number VARCHAR(10), "
                    + "PRIMARY KEY(id));";

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(ConnectionData.URL, ConnectionData.USER, ConnectionData.PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_QUERY);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
