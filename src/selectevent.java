
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.Statement;
    
    public class selectevent {
        public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/demo";
            String username = "postgres";
            String password = "thebigboss"; 
    
            String query = "SELECT * FROM events";
    
            try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
            ) {
                // Process the result set
                while (resultSet.next()) {
                    System.out.println(
                        resultSet.getInt("id_event") + " - " +
                        resultSet.getString("nom_event") + " - " +
                        resultSet.getDate("date_event") + " - " +
                        resultSet.getString("description") + " - " +
                        resultSet.getInt("id_user") 
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

