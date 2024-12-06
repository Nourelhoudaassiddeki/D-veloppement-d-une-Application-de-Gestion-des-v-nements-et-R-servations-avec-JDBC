import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class selectuser {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "thebigboss"; 

        String query = "SELECT * FROM users";

        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {
            // Process the result set
            while (resultSet.next()) {
                System.out.println(
                    resultSet.getInt("id_user") + " - " +
                    resultSet.getString("nom") + " - " +
                    resultSet.getString("prenom") + " - " +
                    resultSet.getString("type") + " - " +
                    resultSet.getString("email") // Corrected to getString
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

