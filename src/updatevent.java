

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    public class updatevent {
        public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/demo";
            String username = "postgres";
            String password = "thebigboss"; 
 
            String query = "UPDATE events SET nom_event='reunion',description='exams schedule' WHERE nom_event='weeding'";
         
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
              PreparedStatement st=conn.prepareStatement(query);
                st.executeUpdate();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

