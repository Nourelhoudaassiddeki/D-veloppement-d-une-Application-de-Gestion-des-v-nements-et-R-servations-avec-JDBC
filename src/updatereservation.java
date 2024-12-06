


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    public class updatereservation {
        public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/demo";
            String username = "postgres";
            String password = "thebigboss"; 
 
            String query = "UPDATE reservation SET date_reservation='2024-12-12' WHERE id_terrain='2'";
         
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
              PreparedStatement st=conn.prepareStatement(query);
                st.executeUpdate();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


