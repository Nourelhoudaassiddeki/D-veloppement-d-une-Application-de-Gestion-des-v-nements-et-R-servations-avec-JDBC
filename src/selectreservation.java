


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class selectreservation {
    public static void main(String[] args) {
       
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "thebigboss"; 

        String query = "SELECT * FROM reservation";

        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {
           
            while (resultSet.next()) {
                System.out.println(
                    resultSet.getInt("id_reservation") + " - " +
                    resultSet.getInt("id_user") + " - " +
                    resultSet.getInt("id_event") + " - " +
                    resultSet.getInt("id_salle") + " - " +
                    resultSet.getInt("id_terrain")  + " - " +
                    resultSet.getDate("date_reservation")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

