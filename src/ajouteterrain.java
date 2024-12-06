

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.util.Scanner;
    public class ajouteterrain {
    public static void main(String[] args) {
        
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "thebigboss"; 
    
        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in)
        ) {
            // Input details
            System.out.println("Enter name of the terrain :");
            String terrainame = scanner.nextLine();
    
            System.out.println("Enter type:");
            String type= scanner.nextLine();

          
            // Use schema prefix for the table
            String sql = "INSERT INTO terrains (nom_terrain,type) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,terrainame);
                pstmt.setString(2, type);

                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted successfully!");
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

