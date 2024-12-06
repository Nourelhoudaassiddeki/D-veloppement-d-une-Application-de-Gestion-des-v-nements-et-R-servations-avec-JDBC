import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ajouteuser {
    public static void main(String[] args) {
       
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "thebigboss"; 

        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in)
        ) {
         
            System.out.println("Enter your last name:");
            String nom = scanner.nextLine();

            System.out.println("Enter your first name:");
            String prenom = scanner.nextLine();

            System.out.println("Who are you?");
            String type = scanner.nextLine();
            System.out.println("enter ur email");
            String email= scanner.nextLine();
           
            String sql = "INSERT INTO users (nom, prenom, type,email) VALUES (?, ?, ?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nom);
                pstmt.setString(2, prenom);
                pstmt.setString(3, type);
                pstmt.setString(4, email);
                // Execute the query
                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted successfully!");
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


