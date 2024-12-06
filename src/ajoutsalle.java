
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.util.Scanner;
    public class ajoutsalle {
    public static void main(String[] args) {
       
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "thebigboss"; 
    
        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in)
        ) {
           
            System.out.println("Enter name of the hall :");
            String sallename = scanner.nextLine();
    
            System.out.println("Enter capacity:");
            String capacity= scanner.nextLine();

          
           
            String sql = "INSERT INTO salle (nom_salle,capacite) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,sallename);
                pstmt.setString(2, capacity);

                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted successfully!");
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
